package com.dotterbear.singleton.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dotterbear.singleton.pattern.SingletonObject;

import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void test1() {
        SingletonObject instance1 = SingletonObject.getInstance();
        SingletonObject instance2 = SingletonObject.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void test2() {
        SingletonObjectTwo instance1 = SingletonObjectTwo.getInstance();
        SingletonObjectTwo instance2 = SingletonObjectTwo.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void test3() {
        SingletonObjectThree instance1 = SingletonObjectThree.INSTANCE;
        SingletonObjectThree instance2 = SingletonObjectThree.INSTANCE;
        assertEquals(instance1, instance2);
    }
}
