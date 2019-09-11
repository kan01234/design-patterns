package com.dotterbear.observer.pattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingSubject implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String data) {
        observers.stream().forEach(observer -> observer.update(data));
    }

}