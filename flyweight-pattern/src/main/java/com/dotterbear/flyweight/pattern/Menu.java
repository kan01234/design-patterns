package com.dotterbear.flyweight.pattern;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    public static final Map<String, MenuItem> MENU = new HashMap<>();

    public MenuItem order(String name, boolean isFood) {
        return MENU.computeIfAbsent(name, n -> {
            System.out.println("creating menu item: "+ n);
            int price = (int) (Math.random() * 100);
            return isFood ? new Food(n, price) : new Drink(name, price);
        });
    }

}