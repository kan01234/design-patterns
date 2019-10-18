package com.dotterbear.abztract.factory.pattern;

public class VegetarianFastFoodFactory implements FastFoodFactory {

    @Override
    public Hamburger createHamburger() {
        return new FakeMeatHamburger();
    }

    @Override
    public Nugget createNugget() {
        return new FakeMeatNugget();
    }

}