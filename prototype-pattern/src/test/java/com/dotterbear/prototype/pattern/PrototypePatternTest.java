package com.dotterbear.prototype.pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class PrototypePatternTest {

    @Test
    public void AnimalTest() {
        Animal sheep = new Sheep();
        Animal sheepCopy = sheep.makeCopy();
        Animal pig = new Pig();
        Animal pigCopy = pig.makeCopy();
        assertFalse(sheep.equals(sheepCopy));
        assertFalse(pig.equals(pigCopy));
    }

}