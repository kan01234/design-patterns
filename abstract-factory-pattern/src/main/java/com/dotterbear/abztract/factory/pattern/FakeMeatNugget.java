package com.dotterbear.abztract.factory.pattern;

public class FakeMeatNugget implements Nugget {

    @Override
    public void fired() {
        System.out.println("fired fake meat nugget for 3 minutes");
    }

    @Override
    public void pack() {
        System.out.println("pack 9 pieces of fake meat nugget into box");
    }

    @Override
    public boolean isVegetarian() {
        return true;
    }

}