package com.dotterbear.simple.factory.pattern;

public class BeefHamburger implements Hamburger {

    @Override
    public void pack() {
        System.out.println("pack beef hamburger into paper box");
    }

    @Override
    public boolean isVegetarian() {
        return false;
    }

}