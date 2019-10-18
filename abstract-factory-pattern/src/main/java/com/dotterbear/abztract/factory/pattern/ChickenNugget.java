package com.dotterbear.abztract.factory.pattern;

public class ChickenNugget implements Nugget {

    @Override
    public void fired() {
        System.out.println("fired chicken nugget for 6 minutes");
    }

    @Override
    public void pack() {
        System.out.println("pack 6 pieces of chicken nugget into box");
    }

    @Override
    public boolean isVegetarian() {
        return false;
    }

}