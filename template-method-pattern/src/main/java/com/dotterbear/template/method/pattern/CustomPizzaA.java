package com.dotterbear.template.method.pattern;

public class CustomPizzaA extends Pizza {

    @Override
    public void addMeat() {
        System.out.println("add ham");
    }

    @Override
    public void addVegetable() {
        System.out.println("add onion");
    }

    @Override
    public void addSauce() {
        System.out.println("add tomato sauce");
    }

    @Override
    public void addCheese() {
        System.out.println("add mozzarella cheese");
    }

}