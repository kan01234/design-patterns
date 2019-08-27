package com.dotterbear.flyweight.pattern;

public class Food extends MenuItem {

    protected final boolean TAKE_AWAY = false;

    public Food(String name, int price) {
        super(name, price);
    }

    @Override
    public void order() {
        System.out.println("order food: " + name + ", price: " + price + ", can take away: " + TAKE_AWAY);
    }

}