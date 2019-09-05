package com.dotterbear.mediator.pattern;

public class AutoSellingMachineMediator implements ComponentMediator {

    private CoinSlot coinSlot;

    public void setCoinSlot(CoinSlot coinSlot) {
        this.coinSlot = coinSlot;
    }

    @Override
    public void buy() {
        if (coinSlot.isHasCoin()) {
            System.out.println("buy is ok, thanks you.");
            coinSlot.setHasCoin(false);
        } else {
            System.out.println("no coin, please insert coin before buy");
        }
    }

    @Override
    public void refund() {
        if (coinSlot.isHasCoin()) {
            System.out.println("refund is ok, bye bye.");
            coinSlot.setHasCoin(false);
        } else {
            System.out.println("no coin");
        }
    }

    @Override
    public void insertCoin() {
        if (coinSlot.isHasCoin()) {
            System.out.println("has coin already");
        } else {
            coinSlot.insertCoin();
        }
    }

}