package com.dotterbear.template.method.pattern;

public class CustomPizzaB extends Pizza {

    @Override
    public void addMeat() {
        System.out.println("add bacon");
    }

    @Override
    public void addVegetable() {
        System.out.println("add mushrooms");
    }

    @Override
    public void addSauce() {
        System.out.println("add bbq sauce");
    }

    @Override
    public void addCheese() {
        System.out.println("add parmesan cheese");
    }

}