package com.dotterbear.builder.pattern;

public class Animal {

    private String name;

    private double weight;

    private double height;

    private String gender;

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public Animal setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public Animal setHeight(double height) {
        this.height = height;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Animal setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "Animal [Gender=" + gender + ", height=" + height + ", name=" + name + ", weight=" + weight + "]";
    }

}