package com.dotterbear.decorator.pattern;

import java.util.List;

public class Onion extends HamburgerDecorator {

    public Onion(Hamburger hamburger) {
        super(hamburger);
    }
    
    @Override
    public List<String> getIngredients() {
        List<String> descriptions = super.getIngredients();
        descriptions.add("onion");
        return descriptions;
    }

    @Override
    public List<Integer> getPrices() {
        List<Integer> prices = super.getPrices();
        prices.add(8);
        return prices;
    }

}