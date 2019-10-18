package com.dotterbear.abztract.factory.pattern;

public class NormalFastFoodFactory implements FastFoodFactory {

    @Override
    public Hamburger createHamburger() {
        return new BeefHamburger();
    }

    @Override
    public Nugget createNugget() {
        return new ChickenNugget();
    }

}