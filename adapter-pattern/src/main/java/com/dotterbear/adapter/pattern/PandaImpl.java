package com.dotterbear.adapter.pattern;

public class PandaImpl implements Panda {

    @Override
    public String eat() {
        return "lazy panda, eat Bamboo";
    }

    @Override
    public String hello() {
        return "lazy panda, sleeping";
    }

    @Override
    public String sit() {
        return "lazy panda, goin to sleep";
    }

}