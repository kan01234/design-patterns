package com.dotterbear.template.method.pattern;

public abstract class Pizza {

    public final void makePizza() {
        makeDough();
        addSauce();
        addCheese();
        if (!isVegetarian())
            addMeat();
        addVegetable();
        bakePizza();
        cutPizza();
    }

    public void makeDough() {
        System.out.println("make pizza dough");
    }

    public void bakePizza() {
        System.out.println("bake pizza");
    }

    public void cutPizza() {
        System.out.println("cut pizza");
    }

    public abstract void addMeat();

    public abstract void addVegetable();

    public abstract void addSauce();

    public abstract void addCheese();

    public boolean isVegetarian() {
        return false;
    }

}