package com.dotterbear.flyweight.pattern;

public abstract class MenuItem {

    protected String name;

    protected int price;

    public abstract void order();

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

}