package com.dotterbear.facade.pattern;

import org.junit.jupiter.api.Test;

public class FacadePatternTest {

    @Test
    public void test() {
        BreakfastFacade breakfastFacade = new BreakfastFacade();
        breakfastFacade.serve();
    }

}