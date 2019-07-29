package com.dotterbear.decorator.pattern;

import java.util.List;

import com.dotterbear.decorator.pattern.Hamburger;

public abstract class HamburgerDecorator implements Hamburger {

    private Hamburger hamburger;

    public HamburgerDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public List<String> getIngredients() {
        return hamburger.getIngredients();
    }

    @Override
    public List<Integer> getPrices() {
        return hamburger.getPrices();
    }

}