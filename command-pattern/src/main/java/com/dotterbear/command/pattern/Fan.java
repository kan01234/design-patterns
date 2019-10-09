package com.dotterbear.command.pattern;

public class Fan {

    private boolean powerOn;

    public Fan() {
        powerOn = false;
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    @Override
    public String toString() {
        return "Fan [powerOn=" + powerOn + "]";
    }

    public void turnOn() {
        powerOn = true;
        System.out.println("turn on the fan");
    }

    public void turnOff() {
        powerOn = false;
        System.out.println("turn off the fan");
    }

}