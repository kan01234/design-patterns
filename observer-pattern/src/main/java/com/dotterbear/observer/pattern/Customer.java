package com.dotterbear.observer.pattern;

public class Customer implements Observer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String data) {
        System.out.println(name + ": " + data + " is on sales");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}