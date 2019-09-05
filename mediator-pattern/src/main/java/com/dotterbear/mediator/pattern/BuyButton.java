package com.dotterbear.mediator.pattern;

public class BuyButton extends Button  {

    @Override
    public void press() {
        componentMediator.buy();
    }

}
