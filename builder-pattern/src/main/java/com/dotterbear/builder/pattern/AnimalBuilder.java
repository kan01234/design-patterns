package com.dotterbear.builder.pattern;

public interface AnimalBuilder {

    public AnimalBuilder setName(String name);

    public AnimalBuilder setWeight(double weight);

    public AnimalBuilder setHeight(double height);

    public AnimalBuilder setGender(String gender);

    public Animal build();

}