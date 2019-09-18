package com.dotterbear.strategy.pattern;

public class Beginner extends PokemonTrainer {

    public Beginner() {
        super();
        throwStrategy = new ThrowRegualr();
    }

}