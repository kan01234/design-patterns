package com.dotterbear.template.method.pattern;

import org.junit.jupiter.api.Test;

public class TemplateMethodPatternTest {

    @Test
    public void PizzaTest() {
        Pizza pizzaA = new CustomPizzaA();
        System.out.println("make pizza a");
        pizzaA.makePizza();
        Pizza pizzaB = new CustomPizzaB();
        System.out.println("make pizza b");
        pizzaB.makePizza();
        Pizza pizzaC = new CustomPizzaC();
        System.out.println("make pizza c");
        pizzaC.makePizza();
    }

}