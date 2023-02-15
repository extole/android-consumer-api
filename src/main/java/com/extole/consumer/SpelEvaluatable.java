package com.extole.consumer;

import com.extole.consumer.Evaluatable;

public interface SpelEvaluatable<CONTEXT, RESULT> extends Evaluatable<CONTEXT, RESULT> {

    String getExpression();

}
