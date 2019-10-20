package com.dotterbear.builder.pattern;

public class SmallDogBuilder implements AnimalBuilder {

    private String name;

    private double weight;

    private double height;

    private String gender;

    @Override
    public Animal build() {
        return new Animal()
                .setName(name)
                .setWeight(weight)
                .setHeight(height)
                .setGender(gender);
    }

    @Override
    public AnimalBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public AnimalBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public AnimalBuilder setHeight(double height) {
        this.height = height;
        return this;
    }

    @Override
    public AnimalBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

}