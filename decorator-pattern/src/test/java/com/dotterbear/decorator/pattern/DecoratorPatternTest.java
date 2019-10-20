package com.dotterbear.decorator.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    public void test() {
        Hamburger hamburger1 = new Onion(new Beef(new PlainHamburger()));
        Hamburger hamburger2 = new Beef(new PlainHamburger());
        System.out.println("hamburger1: " + String.join(",", hamburger1.getIngredients()) + ". cost: " + hamburger1.getPrices().stream().mapToInt(Integer::intValue).sum());
        System.out.println("hamburger2: " + String.join(",", hamburger2.getIngredients()) + ". cost: " + hamburger2.getPrices().stream().mapToInt(Integer::intValue).sum());
        assertEquals(Arrays.asList("plain bread", "beef", "onion"), hamburger1.getIngredients());
        assertEquals(Arrays.asList("plain bread", "beef"), hamburger2.getIngredients());
        assertEquals(Arrays.asList(5, 30, 8), hamburger1.getPrices());
        assertEquals(Arrays.asList(5, 30), hamburger2.getPrices());
    }

}