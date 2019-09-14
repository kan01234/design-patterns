package com.dotterbear.prototype.pattern;

public class Pig implements Animal {

    public Pig() {
        System.out.println("new Pig");
    }

    public Animal makeCopy() {
        System.out.println("making a Pig copy");
        Pig pig = null;
        try {
            pig = (Pig) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return pig;
    }

}