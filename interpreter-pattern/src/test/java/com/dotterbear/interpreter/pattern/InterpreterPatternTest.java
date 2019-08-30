package com.dotterbear.interpreter.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class InterpreterPatternTest {

    @Test
    public void test() {
        List<String> strs = Arrays.asList("hello", "GO TO School by bus", "bye bye");
        Expression toLowercase = new ToLowercase();
        Expression addSlash = new AddSlash();
        Expression expression = new ToLowercaseAndAddSlash();

        strs
                .stream()
                .map(str -> addSlash.interpret(str))
                .forEach(System.out::println);

        strs
                .stream()
                .map(str -> toLowercase.interpret(str))
                .forEach(System.out::println);
        
        strs
                .stream()
                .map(str -> expression.interpret(str))
                .forEach(System.out::println);
        
        assertEquals("hello", toLowercase.interpret("HELLO"));
        assertEquals("abc-def-g", addSlash.interpret("abcdefg"));
        assertEquals("abc-d", expression.interpret("ABCD"));
    }

}