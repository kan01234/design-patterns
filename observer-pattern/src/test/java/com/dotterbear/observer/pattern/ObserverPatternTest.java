package com.dotterbear.observer.pattern;

import org.junit.jupiter.api.Test;

public class ObserverPatternTest {

    @Test
    public void test() {
        Subject subject = new ShoppingSubject();
        Observer observer1 = new Customer("peter");
        Observer observer2 = new Customer("mary");
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.notifyObserver("cola");
        subject.removeObserver(observer1);
        subject.notifyObserver("soda");
    }

}