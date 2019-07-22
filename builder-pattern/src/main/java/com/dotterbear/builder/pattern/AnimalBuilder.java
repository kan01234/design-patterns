package com.dotterbear.builder.pattern;

public interface AnimalBuilder {

    public AnimalBuilder buildName();

    public AnimalBuilder buildWeight();

    public AnimalBuilder buildHeight();

    public AnimalBuilder buildGender();

    public Animal build();

}