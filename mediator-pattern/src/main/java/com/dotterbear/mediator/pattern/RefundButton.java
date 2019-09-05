package com.dotterbear.mediator.pattern;

public class RefundButton extends Button {

    @Override
    public void press() {
        componentMediator.refund();
    }

}
