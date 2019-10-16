package com.dotterbear.simple.factory.pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SimpleFactoryPatternTest {

    @Test
    public void test() {
        SimpleHamburgerFactory hamburgerFactory = new SimpleHamburgerFactory();
        Hamburger beefHamburger = hamburgerFactory.makeHamburger("beef");
        Hamburger fakeMeatHamburger = hamburgerFactory.makeHamburger("fake meat");
        assertTrue(beefHamburger instanceof BeefHamburger);
        assertTrue(fakeMeatHamburger instanceof FakeMeatHamburger);
        beefHamburger.pack();
        fakeMeatHamburger.pack();
    }

}