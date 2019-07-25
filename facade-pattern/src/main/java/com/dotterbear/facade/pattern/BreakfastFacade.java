package com.dotterbear.facade.pattern;

public class BreakfastFacade {

    private Egg egg;

    private Bacon bacon;

    private EnglishMuffin englishMuffin;

    public void serve() {
        englishMuffin.cut();
        englishMuffin.hot();
        bacon.cook();
        egg.open();
        egg.mix();
        egg.cook();
    }

    public BreakfastFacade() {
        this.egg = new Egg();
        this.bacon = new Bacon();
        this.englishMuffin = new EnglishMuffin();
    }

}