package com.dotterbear.flyweight.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FlyWeightPatternTest {

    @Test
    public void test() {
        Menu menu = new Menu();
        MenuItem menuItem1, menuItem2;
        menuItem1 = menu.order("cole", false);
        menuItem2 = menu.order("cole", false);
        assertTrue(menuItem1 == menuItem2);
        menuItem1 = menu.order("water", false);
        menuItem2 = menu.order("water", false);
        assertTrue(menuItem1 == menuItem2);
        menuItem1 = menu.order("beer", false);
        menuItem2 = menu.order("beer", false);
        assertTrue(menuItem1 == menuItem2);
        menuItem1.order();
        menuItem1 = menu.order("sushi", true);
        menuItem2 = menu.order("sushi", true);
        assertTrue(menuItem1 == menuItem2);
        menuItem2 = menu.order("ramen", true);
        menuItem1.order();
        menuItem2.order();
    }

}