package com.dotterbear.strategy.pattern;

public class Expert extends PokemonTrainer {
    
    public Expert() {
        super();
        throwStrategy = new ThrowGreat();
    }

}