package com.dotterbear.builder.pattern;

public class Animal implements AnimalPlan {

    private String name;

    private double weight;

    private double height;

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal [Gender=" + gender + ", height=" + height + ", name=" + name + ", weight=" + weight + "]";
    }

}