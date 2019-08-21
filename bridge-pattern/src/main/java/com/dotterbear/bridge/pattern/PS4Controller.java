package com.dotterbear.bridge.pattern;

public class PS4Controller implements Controller {

    private ControllerFunction controllerFunction;

    public PS4Controller(ControllerFunction controllerFunction) {
        this.controllerFunction = controllerFunction;
    }

    @Override
    public void joystickMove(String direction) {
        controllerFunction.joystickMove(direction);
    }

    @Override
    public void pressHome() {
        controllerFunction.pressHome();
    }
    
}