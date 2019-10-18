package com.dotterbear.abztract.factory.pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AbstractFactoryPatternTest {

    @Test
    public void test() {
        FastFoodFactory fastFoodFactory = null;
        Hamburger hamburger = null;
        Nugget nugget = null;
        // make normal fast food
        fastFoodFactory = new NormalFastFoodFactory();
        hamburger = fastFoodFactory.createHamburger();
        nugget = fastFoodFactory.createNugget();
        assertFalse(hamburger.isVegetarian());
        assertFalse(nugget.isVegetarian());
        // make vegetarian fast food
        fastFoodFactory = new VegetarianFastFoodFactory();
        hamburger = fastFoodFactory.createHamburger();
        nugget = fastFoodFactory.createNugget();
        assertTrue(hamburger.isVegetarian());
        assertTrue(nugget.isVegetarian());
    }

}