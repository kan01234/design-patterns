package com.dotterbear.simple.factory.pattern;

public class SimpleHamburgerFactory {
    
    public Hamburger makeHamburger(String order) {
        switch (order) {
            case "beef":
                return new BeefHamburger();
            case "fake meat":
                return new FakeMeatHamburger();
            default:
                return null;
        }
    }

}