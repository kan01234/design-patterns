package com.dotterbear.command.pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CommandPatternTest {

    @Test
    public void test() {
        Fan fan = new Fan();
        FanRemote fanRemote = new FanRemote();
        TurnOnCommand turnOnCommand = new TurnOnCommand(fan);
        TurnOffCommand turnOffCommand = new TurnOffCommand(fan);
        fanRemote.set(0, turnOnCommand);
        fanRemote.set(1, turnOffCommand);
        assertFalse(fan.isPowerOn());
        fanRemote.execute(0);
        assertTrue(fan.isPowerOn());
        fanRemote.execute(1);
        assertFalse(fan.isPowerOn());
    }

    @Test
    public void test2() {
        // not work with undo method
        // Fan fan = new Fan();
        // FanRemote fanRemote = new FanRemote();
        // fanRemote.set(0, fan::turnOn);
        // fanRemote.set(1, fan::turnOff);
        // assertFalse(fan.isPowerOn());
        // fanRemote.execute(0);
        // assertTrue(fan.isPowerOn());
        // fanRemote.execute(1);
        // assertFalse(fan.isPowerOn());
    }

    @Test
    public void test3() {
        Fan fan = new Fan();
        FanRemote fanRemote = new FanRemote();
        TurnOnCommand turnOnCommand = new TurnOnCommand(fan);
        TurnOffCommand turnOffCommand = new TurnOffCommand(fan);
        fanRemote.set(0, turnOnCommand);
        fanRemote.set(1, turnOffCommand);
        assertFalse(fan.isPowerOn());
        fanRemote.execute(0);
        assertTrue(fan.isPowerOn());
        fanRemote.undo();
        assertFalse(fan.isPowerOn());
        fanRemote.execute(1);
        assertFalse(fan.isPowerOn());
        fanRemote.undo();
        assertTrue(fan.isPowerOn());
    }
}