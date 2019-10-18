package com.dotterbear.abztract.factory.pattern;

public class FakeMeatHamburger implements Hamburger {

    @Override
    public void pack() {
        System.out.println("pack fake meat hamburger with paper");
    }

    @Override
    public boolean isVegetarian() {
        return true;
    }

}