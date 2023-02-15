package com.extole.consumer;

import com.fasterxml.jackson.databind.JavaType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.extole.consumer.BuildtimeEvaluatable;

public final class SpelBuildtimeEvaluatable<CONTEXT, RESULT>
    implements BuildtimeEvaluatable<CONTEXT, RESULT>, SpelEvaluatable<CONTEXT, RESULT> {

    private final String expression;
    private final JavaType expectedResultType;

    public SpelBuildtimeEvaluatable(String expression, JavaType expectedResultType) {
        this.expression = expression;
        this.expectedResultType = expectedResultType;
    }

    @Override
    public String getExpression() {
        return expression;
    }

    @Override
    public JavaType getExpectedResultType() {
        return expectedResultType;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(this.expression)
            .append(this.expectedResultType)
            .build()
            .intValue();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || otherObject.getClass() != SpelBuildtimeEvaluatable.class) {
            return false;
        }

        SpelBuildtimeEvaluatable otherEvaluatable = (SpelBuildtimeEvaluatable) otherObject;

        return new EqualsBuilder()
            .append(this.expression, otherEvaluatable.expression)
            .append(this.expectedResultType, otherEvaluatable.expectedResultType)
            .build()
            .booleanValue();
    }

}
