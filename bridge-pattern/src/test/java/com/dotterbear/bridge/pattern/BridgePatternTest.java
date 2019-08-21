package com.dotterbear.bridge.pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BridgePatternTest {

    @Test
    public void test() {
        Controller ps4ControllerWithPS4 = new PS4Controller(new PS4Function());
        Controller ps4ControllerWithSteam = new PS4Controller(new SteamFunction());
        System.out.println("move joystick up");
        ps4ControllerWithPS4.joystickMove("up");
        ps4ControllerWithSteam.joystickMove("up");
        System.out.println("press ps button");
        ps4ControllerWithPS4.pressHome();
        ps4ControllerWithSteam.pressHome();
    }

}