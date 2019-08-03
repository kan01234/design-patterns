package com.dotterbear.composite.pattern;

public abstract class Game {

    public void add(Game game) {
        throw new UnsupportedOperationException();
    }

    public void remove(Game game) {
        throw new UnsupportedOperationException();
    }

    public Game getGame(int index) {
        throw new UnsupportedOperationException();
    }

    public abstract void displayInfo();

}