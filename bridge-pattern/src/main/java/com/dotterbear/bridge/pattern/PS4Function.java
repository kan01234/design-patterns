package com.dotterbear.bridge.pattern;

public class PS4Function implements ControllerFunction {

    @Override
    public void joystickMove(String direction) {
        System.out.println("move " + direction);
    }

    @Override
    public void pressHome() {
        System.out.println("show PS4 home menu");
    }

}