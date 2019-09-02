package com.dotterbear.iterator.pattern;

import java.util.List;

public class FoodMenu implements Menu {

    private List<MenuItem> foods;

    public FoodMenu(List<MenuItem> foods) {
        this.foods = foods;
    }

    @Override
    public MenuIterator createIterator() {
        return new FoodMenuIterator(foods);
    }

    public List<MenuItem> getFoods() {
        return foods;
    }

    public void setFoods(List<MenuItem> foods) {
        this.foods = foods;
    }

}