package com.dotterbear.iterator.pattern;

public class DrinkMenuIterator implements MenuIterator {

    private MenuItem[] drinks;

    private int cur;

    public DrinkMenuIterator(MenuItem[] drinks) {
        this.drinks = drinks;
        cur = 0;
    }

    @Override
    public boolean hasNext() {
        return drinks != null && cur < drinks.length;
    }

    @Override
    public MenuItem next() {
        return drinks[cur++];
    }

}