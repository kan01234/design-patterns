package com.dotterbear.decorator.pattern;

import java.util.ArrayList;
import java.util.List;

public class PlainHamburger implements Hamburger {

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("plain bread");
        return ingredients;
    }

    @Override
    public List<Integer> getPrices() {
        List<Integer> prices = new ArrayList<Integer>();
        prices.add(5);
        return prices;
    }

}