package com.extole.consumer;

import static com.extole.consumer.Evaluatable.BUILDTIME;
import static com.extole.consumer.Evaluatable.EVALUATABLE_SYNTAX_PATTERN;
import static com.extole.consumer.Evaluatable.JAVASCRIPT;
import static com.extole.consumer.Evaluatable.RUNTIME;
import static com.extole.consumer.Evaluatable.SPEL;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.apache.commons.lang3.StringUtils;


final class EvaluatableDeserializer extends StdDeserializer<Evaluatable<?, ?>>
    implements ContextualDeserializer {

    private static final int REGEX_LANGUAGE_GROUP_INDEX = 1;
       private static final int REGEX_PHASE_GROUP_INDEX = 2;
       private static final int REGEX_EXPRESSION_GROUP_INDEX = 3;
       private static final Map<String, Set<?>> SUPPORTED_EVALUATABLE_TYPES = new HashMap<>();

       static {
           SUPPORTED_EVALUATABLE_TYPES.put(BUILDTIME, new HashSet<>(
               Arrays.asList(Evaluatable.class, BuildtimeEvaluatable.class, JavascriptBuildtimeEvaluatable.class,
                   SpelBuildtimeEvaluatable.class)));
           SUPPORTED_EVALUATABLE_TYPES.put(RUNTIME, new HashSet<>(
               Arrays.asList(Evaluatable.class, RuntimeEvaluatable.class, JavascriptRuntimeEvaluatable.class,
                   SpelRuntimeEvaluatable.class)));
       }

    private JavaType evaluatableResultType;
    private Class<?> evaluatableType;
    private boolean root;

    EvaluatableDeserializer() {
        super((JavaType) null);
    }

    @Override
    public Evaluatable<?, ?> deserialize(JsonParser parser, DeserializationContext deserializationContext)
        throws IOException {

        if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
            return tryParseEvaluatable(parser, deserializationContext);
        }
        return providedEvaluatable(parser, deserializationContext);
    }

    private Evaluatable<?, ?> providedEvaluatable(JsonParser parser, DeserializationContext deserializationContext)
        throws IOException {
        return Provided.of(getDefaultDeserializer(deserializationContext).deserialize(parser, deserializationContext));
    }

    private Evaluatable<?, ?> tryParseEvaluatable(JsonParser parser, DeserializationContext deserializationContext)
        throws IOException {
        String value = unwrapRoot(deserializationContext.readValue(parser, String.class));
        Matcher matcher = EVALUATABLE_SYNTAX_PATTERN.matcher(value);

        if (!matcher.matches()) {
            return providedEvaluatable(parser, deserializationContext);
        }

        String language = matcher.group(REGEX_LANGUAGE_GROUP_INDEX);
        String phase = matcher.group(REGEX_PHASE_GROUP_INDEX);
        String expression = matcher.group(REGEX_EXPRESSION_GROUP_INDEX);

        if (SUPPORTED_EVALUATABLE_TYPES.get(phase).contains(evaluatableType)) {
            switch (language) {
                case SPEL:
                    if (BUILDTIME.equals(phase)) {
                        return new SpelBuildtimeEvaluatable<>(expression, evaluatableResultType);
                    }
                    if (RUNTIME.equals(phase)) {
                        return new SpelRuntimeEvaluatable<>(expression, evaluatableResultType);
                    }
                case JAVASCRIPT:
                    if (BUILDTIME.equals(phase)) {
                        return new JavascriptBuildtimeEvaluatable<>(expression, evaluatableResultType);
                    }
                    if (RUNTIME.equals(phase)) {
                        return new JavascriptRuntimeEvaluatable<>(expression, evaluatableResultType);
                    }
                default:
                    throw MismatchedInputException.from(deserializationContext, "This should never happen");
            }
        } else {
            return providedEvaluatable(parser, deserializationContext);
        }
    }

    private String unwrapRoot(String value) {
        return root ? StringUtils.removeStart(StringUtils.removeEnd(value, "\""), "\"") : value;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext,
        BeanProperty beanProperty) throws JsonMappingException {
        JavaType contextualType = deserializationContext.getContextualType();

        if (!Evaluatable.class.isAssignableFrom(contextualType.getRawClass())) {
            throw InvalidDefinitionException.from(deserializationContext,
                "This deserializer supports only " + Evaluatable.class.getSimpleName());
        }

        if (contextualType.getBindings().size() != 2) {
            throw InvalidDefinitionException.from(deserializationContext,
                "Raw Evaluatable is not supported. Both type parameters must be specified.");
        }

        this.root = beanProperty == null;
        this.evaluatableType = contextualType.getRawClass();
        this.evaluatableResultType = contextualType.getBindings().getBoundType(1);
        return this;
    }

    private JsonDeserializer<?> getDefaultDeserializer(DeserializationContext deserializationContext)
        throws JsonMappingException {
        return deserializationContext.findRootValueDeserializer(evaluatableResultType);
    }

    @Override
    public Evaluatable<?, ?> getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
        if (evaluatableResultType.isTypeOrSubTypeOf(Evaluatable.class)) {
            return Provided.of(getDefaultDeserializer(deserializationContext).getNullValue(deserializationContext));
        }
        if (Optional.class == evaluatableResultType.getRawClass()) {
            return Provided.EMPTY;
        } else {
            return Provided.NULL;
        }
    }
}
