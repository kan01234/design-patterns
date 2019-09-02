package com.dotterbear.iterator.pattern;

public class DrinkMenu implements Menu {

    private MenuItem[] drinks;

    public DrinkMenu(MenuItem[] drinks) {
        this.drinks = drinks;
    }

    @Override
    public MenuIterator createIterator() {
        return new DrinkMenuIterator(drinks);
    }

    public MenuItem[] getDrinks() {
        return drinks;
    }

    public void setDrinks(MenuItem[] drinks) {
        this.drinks = drinks;
    }

}