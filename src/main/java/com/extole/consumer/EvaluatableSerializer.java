package com.extole.consumer;

import static com.extole.consumer.Evaluatable.BUILDTIME;
import static com.extole.consumer.Evaluatable.EXPRESSION_DELIMITER;
import static com.extole.consumer.Evaluatable.JAVASCRIPT;
import static com.extole.consumer.Evaluatable.PHASE_DELIMITER;
import static com.extole.consumer.Evaluatable.RUNTIME;
import static com.extole.consumer.Evaluatable.SPEL;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class EvaluatableSerializer<CONTEXT, RESULT> extends StdSerializer<Evaluatable<CONTEXT, RESULT>> {

    public EvaluatableSerializer() {
        super(Evaluatable.class, true);
    }

    @Override
    public void serialize(Evaluatable<CONTEXT, RESULT> value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        Object serializable = extractSerializable(value);
        provider.defaultSerializeValue(serializable, gen);
    }

    private Object extractSerializable(Evaluatable<CONTEXT, RESULT> value) {
        if (value instanceof JavascriptEvaluatable) {
            return serializeJavascriptEvaluatable((JavascriptEvaluatable<CONTEXT, RESULT>) value);
        }

        if (value instanceof SpelEvaluatable) {
            return serializeSpelEvaluatable((SpelEvaluatable<CONTEXT, RESULT>) value);
        }

        if (value instanceof Provided) {
            return ((Provided<CONTEXT, RESULT>) value).getValue();
        }
        throw new RuntimeException("Unsupported Evaluatable " + value);
    }

    private String serializeJavascriptEvaluatable(JavascriptEvaluatable<CONTEXT, RESULT> evaluatable) {
        return JAVASCRIPT + PHASE_DELIMITER + phase(evaluatable) + EXPRESSION_DELIMITER + evaluatable.getExpression();
    }

    private String serializeSpelEvaluatable(SpelEvaluatable<CONTEXT, RESULT> evaluatable) {
        return SPEL + PHASE_DELIMITER + phase(evaluatable) + EXPRESSION_DELIMITER + evaluatable.getExpression();
    }

    private String phase(Evaluatable<CONTEXT, RESULT> evaluatable) {
        return RuntimeEvaluatable.class.isAssignableFrom(evaluatable.getClass()) ? RUNTIME : BUILDTIME;
    }

}