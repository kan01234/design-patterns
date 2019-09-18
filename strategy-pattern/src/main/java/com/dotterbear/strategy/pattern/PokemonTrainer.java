package com.dotterbear.strategy.pattern;

public abstract class PokemonTrainer {

    private String name;

    protected ThrowStrategy throwStrategy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThrowStrategy getThrowStrategy() {
        return throwStrategy;
    }

    public void setThrowStrategy(ThrowStrategy throwStrategy) {
        this.throwStrategy = throwStrategy;
    }

    public String throwItem() {
        return throwStrategy.throwItem();
    }

    @Override
    public String toString() {
        return "PokemonTrainer [name=" + name + ", throwStrategy=" + throwStrategy + "]";
    }

}