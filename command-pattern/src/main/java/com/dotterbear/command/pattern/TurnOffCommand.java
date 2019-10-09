package com.dotterbear.command.pattern;

public class TurnOffCommand implements Command {

    private final Fan fan;

    public TurnOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }

}