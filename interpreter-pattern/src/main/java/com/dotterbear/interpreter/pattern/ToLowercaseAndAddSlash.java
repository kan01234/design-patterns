package com.dotterbear.interpreter.pattern;

import java.util.Arrays;
import java.util.List;

public class ToLowercaseAndAddSlash implements Expression {

    private static List<Expression> expressions = Arrays.asList(new ToLowercase(), new AddSlash());

    @Override
    public String interpret(String str) {
        String result = str;
        for(Expression expression : expressions)
            result = expression.interpret(result);
        return result;
    }

}