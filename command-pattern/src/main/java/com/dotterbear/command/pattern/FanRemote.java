package com.dotterbear.command.pattern;

public class FanRemote {
    
    private Command[] commands;

    public FanRemote() {
        commands = new Command[5];
    }

    public void set(int i, Command command) {
        commands[i] = command;
    }

    public void execute(int i) {
        commands[i].execute();
    }

}