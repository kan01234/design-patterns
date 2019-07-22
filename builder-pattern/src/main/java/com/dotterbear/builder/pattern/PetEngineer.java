package com.dotterbear.builder.pattern;

public class PetEngineer {

    private AnimalBuilder animalBuilder;

    public PetEngineer(AnimalBuilder animalBuilder) {
        this.animalBuilder = animalBuilder;
    }

    public Animal getAnimal() {
        return animalBuilder.build();
    }

    public void constructAnimal() {
        animalBuilder
            .buildName()
            .buildWeight()
            .buildHeight()
            .buildGender();
    }

}