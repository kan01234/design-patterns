package com.dotterbear.iterator.pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IteratorPatternTest {

    @Test
    public void test() {
        Menu foodMenu = new FoodMenu(null);
        Menu drinkMenu = new DrinkMenu(null);
        assertFalse(foodMenu.createIterator().hasNext());
        assertFalse(drinkMenu.createIterator().hasNext());
        MenuItem[] drinks = new MenuItem[] {
            new MenuItem("cole", 10),
            new MenuItem("beer", 18),
            new MenuItem("water", 3)
        };
        List<MenuItem> foods = Arrays.asList(
            new MenuItem("ramen", 98),
            new MenuItem("sushi", 68)
        );
        foodMenu = new FoodMenu(foods);
        drinkMenu = new DrinkMenu(drinks);
        printMenu(foodMenu.createIterator());
        printMenu(drinkMenu.createIterator());
        
    }

    public void printMenu(MenuIterator menuIterator) {
        while(menuIterator.hasNext()) {
            MenuItem item = menuIterator.next();
            System.out.println(item);
        }
    }
}