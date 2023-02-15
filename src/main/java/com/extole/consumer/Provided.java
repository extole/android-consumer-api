package com.extole.consumer;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JavaType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.extole.consumer.BuildtimeEvaluatable;
import com.extole.consumer.Evaluatable;
import com.extole.consumer.RuntimeEvaluatable;

public final class Provided<CONTEXT, RESULT> implements Evaluatable<CONTEXT, RESULT>,
    BuildtimeEvaluatable<CONTEXT, RESULT>,
    RuntimeEvaluatable<CONTEXT, RESULT> {

    public static final Provided<?, ?> NULL = Provided.of(null);
    public static final Provided<?, ?> EMPTY = Provided.of(Optional.empty());
    private static final Provided<?, Set<?>> EMPTY_SET = Provided.of(Collections.emptySet());
    private static final Provided<?, List<?>> EMPTY_LIST = Provided.of(Collections.emptyList());
    private static final Provided<?, Boolean> TRUE = Provided.of(Boolean.TRUE);
    private static final Provided<?, Boolean> FALSE = Provided.of(Boolean.FALSE);

    public static <CONTEXT, RESULT> Provided<CONTEXT, RESULT> nullified() {
        return (Provided<CONTEXT, RESULT>) NULL;
    }

    public static <CONTEXT, RESULT> Provided<CONTEXT, Optional<RESULT>> optionalEmpty() {
        return (Provided<CONTEXT, Optional<RESULT>>) EMPTY;
    }

    public static <CONTEXT, RESULT> Provided<CONTEXT, Optional<RESULT>> optionalOf(RESULT value) {
        return Provided.of(Optional.ofNullable(value));
    }

    public static <CONTEXT, RESULT extends Boolean> Provided<CONTEXT, RESULT> booleanTrue() {
        return (Provided<CONTEXT, RESULT>) TRUE;
    }

    public static <CONTEXT, RESULT extends Boolean> Provided<CONTEXT, RESULT> booleanFalse() {
        return (Provided<CONTEXT, RESULT>) FALSE;
    }

    public static <CONTEXT, RESULT extends Set<?>> Provided<CONTEXT, RESULT> emptySet() {
        return (Provided<CONTEXT, RESULT>) EMPTY_SET;
    }

    public static <CONTEXT, RESULT extends List<?>> Provided<CONTEXT, RESULT> emptyList() {
        return (Provided<CONTEXT, RESULT>) EMPTY_LIST;
    }

    public static <CONTEXT, RESULT extends Set<?>> Provided<CONTEXT, RESULT> setOf(Object... values) {
        return Provided.of(Collections.singleton((values)));
    }

    public static <CONTEXT, RESULT extends List<?>> Provided<CONTEXT, RESULT> listOf(Object... values) {
        return Provided.of(Collections.unmodifiableList(Arrays.asList(values)));
    }

    public static <CONTEXT, RESULT extends BigDecimal> Provided<CONTEXT, RESULT> bigDecimalOf(long value) {
        return Provided.of(BigDecimal.valueOf(value));
    }

    public static <CONTEXT, RESULT extends BigDecimal> Provided<CONTEXT, RESULT> bigDecimalOf(double value) {
        return Provided.of(BigDecimal.valueOf(value));
    }

    public static <CONTEXT, RESULT> Provided<CONTEXT, RESULT> of(Object value) {
        return (Provided<CONTEXT, RESULT>) new Provided<>(value);
    }

    private final RESULT value;

    private Provided(RESULT value) {
        this.value = value;
    }

    public RESULT getValue() {
        return value;
    }

    @Override
    public JavaType getExpectedResultType() {
        return null;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(this.value)
            .build()
            .intValue();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || otherObject.getClass() != Provided.class) {
            return false;
        }

        Provided<?, ?> otherEvaluatable = (Provided<?, ?>) otherObject;

        return new EqualsBuilder()
            .append(this.value, otherEvaluatable.value)
            .build()
            .booleanValue();
    }

}
