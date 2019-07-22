package com.dotterbear.builder.pattern;

public class SmallDogBuilder implements AnimalBuilder {

    private Animal dog;

    public SmallDogBuilder() {
        dog = new Animal();
    }

    @Override
    public AnimalBuilder buildName() {
        dog.setName("Dolly");
        return this;
    }

    @Override
    public AnimalBuilder buildWeight() {
        dog.setWeight(20.0);
        return this;
    }

    @Override
    public AnimalBuilder buildHeight() {
        dog.setHeight(40.0);
        return this;
    }

    @Override
    public AnimalBuilder buildGender() {
        dog.setGender("F");
        return this;
    }

    @Override
    public Animal build() {
        return dog;
    }

}