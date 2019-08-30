package com.dotterbear.interpreter.pattern;

public class AddSlash implements Expression {

    @Override
    public String interpret(String str) {
        if (str == null || str.isEmpty())
            return str;

        final int size = 3;
        final String slash = "-";
        int start = 3;
        int strLength = str.length();
        String result = str.substring(0, Math.min(size, strLength));
        while (start < strLength) {
            result += slash + str.substring(start, Math.min(start + size, strLength));
            start += size;
        }
        return result;
    }

}