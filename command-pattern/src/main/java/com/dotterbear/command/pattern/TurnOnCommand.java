package com.dotterbear.command.pattern;

public class TurnOnCommand implements Command {

    private final Fan fan;

    public TurnOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }

    @Override
    public void undo() {
        fan.turnOff();
    }

}