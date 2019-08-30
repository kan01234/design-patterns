package com.dotterbear.interpreter.pattern;

public class ToLowercase implements Expression {

    @Override
    public String interpret(String str) {
        return str.toLowerCase();
    }

}