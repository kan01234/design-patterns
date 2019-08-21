package com.dotterbear.bridge.pattern;

public class SteamFunction implements ControllerFunction {

    @Override
    public void joystickMove(String direction) {
        System.out.println("pressed " + direction);
    }

    @Override
    public void pressHome() {
        System.out.println("unsupported button");
    }

}