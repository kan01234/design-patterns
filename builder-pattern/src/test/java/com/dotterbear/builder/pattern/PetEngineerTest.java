package com.dotterbear.builder.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PetEngineerTest {

    @Test
    public void test() {
        Animal pet;
        AnimalBuilder animalBuilder = new SmallDogBuilder();
        PetEngineer petEngineer = new PetEngineer(animalBuilder);
        petEngineer.constructAnimal();
        pet = petEngineer.getAnimal();
        System.out.println(pet);
        assertTrue(pet instanceof Animal);
        assertEquals("Dolly", pet.getName());
        assertEquals(20.0, pet.getWeight());
        assertEquals(40.0, pet.getHeight());
        assertEquals("F", pet.getGender());
    }

}