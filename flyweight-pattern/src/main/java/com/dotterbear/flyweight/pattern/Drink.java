package com.dotterbear.flyweight.pattern;

public class Drink extends MenuItem {

    public Drink(String name, int price) {
        super(name, price);
    }

    @Override
    public void order() {
        System.out.println("order drink: " + name + ", price: " + price);
    }

}