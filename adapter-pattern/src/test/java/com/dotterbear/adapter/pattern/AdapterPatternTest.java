package com.dotterbear.adapter.pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AdapterPatternTest {

    @Test
    public void test() {
        Panda panda = new PandaImpl();
        Panda fakePanda = new PandaAdapter(new PartTimeWorker());
        System.out.println("real panda");
        System.out.println(panda.eat());
        System.out.println(panda.sit());
        System.out.println(panda.hello());

        System.out.println("fake panda");
        System.out.println(fakePanda.eat());
        System.out.println(fakePanda.sit());
        System.out.println(fakePanda.hello());

        assertTrue(fakePanda instanceof Panda);
        assertTrue(panda instanceof Panda);
    }

}