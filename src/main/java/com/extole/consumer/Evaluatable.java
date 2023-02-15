package com.extole.consumer;

import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = EvaluatableDeserializer.class)
@JsonSerialize(using = EvaluatableSerializer.class)
public interface Evaluatable<CONTEXT, RESULT> {

    String SPEL = "spel";
    String JAVASCRIPT = "javascript";
    String PHASE_DELIMITER = "@";
    String BUILDTIME = "buildtime";
    String RUNTIME = "runtime";
    String EXPRESSION_DELIMITER = ":";

    Pattern EVALUATABLE_SYNTAX_PATTERN = Pattern.compile("^(" + SPEL + "|" + JAVASCRIPT + ")"
        + PHASE_DELIMITER +
        "(" + BUILDTIME + "|" + RUNTIME + ")"
        + EXPRESSION_DELIMITER +
        "((.)+)$",
        Pattern.DOTALL);

    JavaType getExpectedResultType();
}
