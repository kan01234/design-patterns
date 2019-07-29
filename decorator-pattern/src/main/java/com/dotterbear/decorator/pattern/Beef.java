package com.dotterbear.decorator.pattern;

import java.util.List;

public class Beef extends HamburgerDecorator {

    public Beef(Hamburger hamburger) {
        super(hamburger);
    }
    
    @Override
    public List<String> getIngredients() {
        List<String> descriptions = super.getIngredients();
        descriptions.add("beef");
        return descriptions;
    }

    @Override
    public List<Integer> getPrices() {
        List<Integer> prices = super.getPrices();
        prices.add(30);
        return prices;
    }

}