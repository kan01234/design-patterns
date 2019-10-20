package com.dotterbear.builder.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BuilderPatternTest {

    @Test
    public void test() {
        Animal pet;
        AnimalBuilder animalBuilder = new SmallDogBuilder();
        String name = "Dolly";
        double weight = 20.0;
        double height = 40.0;
        String gender = "F";
        pet = animalBuilder.setGender(gender)
                .setName(name)
                .setHeight(height)
                .setWeight(weight)
                .build();
        System.out.println(pet);
        assertTrue(pet instanceof Animal);
        assertEquals("Dolly", pet.getName());
        assertEquals(20.0, pet.getWeight());
        assertEquals(40.0, pet.getHeight());
        assertEquals("F", pet.getGender());
    }

}