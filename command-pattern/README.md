# command-pattern
Project of example of command pattern implement by Java. 

## What is command pattern
encapsulate a request as an object

class diagram:

![command-pattern](https://github.com/kan01234/design-patterns/blob/master/command-pattern/command-pattern.png)

1. Command
    - interface that define the methods like execute, undo and redo

2. ConcreteCommand
    - class that implements Command, usually for specific function

3. Invoker
    - class that contains command and execute the command

4. Receiver
    - class that receive execute request and do action

sequence diagram:

![command-pattern-seq](https://github.com/kan01234/design-patterns/blob/master/command-pattern/command-pattern-seq.png)

Receiver
```java
public class Receiver {
    public void action() {
        // action ...
    }
}
```

Command
```java
public interface Command {
    public void execute();
}
```

ConcreteCommand
```java
public class ConcreteCommand implements Command {

    private Receiver receiver;

    // constructor method...
    
    public void execute() {
        receiver.action();
    }

}
```

## Example
assume we have a fan and allow user to turn of and off the fan by the remote.

class diagram:

![command-pattern](https://github.com/kan01234/design-patterns/blob/master/command-pattern/command-pattern.png)

Fan is the Receiver, have turn on/off method
```java
public class Fan {

    private boolean powerOn;

    // constructor, other method...

    public void turnOn() {
        powerOn = true;
        System.out.println("turn on the fan");
    }

    public void turnOff() {
        powerOn = false;
        System.out.println("turn off the fan");
    }

}
```

Command interface
```java
public interface Command {
    void execute();
}
```

TurnOnCommand, has linked Fan object
```java
public class TurnOnCommand implements Command {

    private final Fan fan;

    // constructor method...

    @Override
    public void execute() {
        fan.turnOn();
    }
}
```

TurnOffCommand, has linked Fan object
```java
public class TurnOffCommand implements Command {

    private final Fan fan;

    // constructor method...

    @Override
    public void execute() {
        fan.turnOff();
    }
}
```

FanRemote, the invoker object will used by the user
```java
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
```

Testing Code

create recevier, invoker
```java
Fan fan = new Fan();
FanRemote fanRemote = new FanRemote();
```

link receiver and concrete command
```java
TurnOnCommand turnOnCommand = new TurnOnCommand(fan);
TurnOffCommand turnOffCommand = new TurnOffCommand(fan);
```

set concrete command to receiver
```java
fanRemote.set(0, turnOnCommand);
fanRemote.set(1, turnOffCommand);
```

turn on the fan by remote
```java
fanRemote.execute(0);
assertTrue(fan.isPowerOn());
```

output
```
turn on the fan
```

turn off the fan by remote
```java
fanRemote.execute(1);
assertFalse(fan.isPowerOn());
```

output
```
turn off the fan
```

## Example (with Java 8)
Continue from above case

class diagram:

![command-pattern example 2](https://github.com/kan01234/design-patterns/blob/master/command-pattern/command-pattern-example-2.png)

do not need to create TurnOnCommand, TurnOffCommand, use :: operator to replace it

```java
Fan fan = new Fan();
FanRemote fanRemote = new FanRemote();
fanRemote.set(0, fan::turnOn);
fanRemote.set(1, fan::turnOff);
fanRemote.execute(0);
assertTrue(fan.isPowerOn());
fanRemote.execute(1);
assertFalse(fan.isPowerOn());
```

## Example (undo)
Continue from above case, but the remote can perform a undo last action now.

![command-pattern example 2](https://github.com/kan01234/design-patterns/blob/master/command-pattern/command-pattern-example-3.png)

add undo method to Command Interface
```java
public interface Command {
    public void execute();
    public void undo();
}
```

implement undo method in TurnOffCommand
```java
public class TurnOffCommand implements Command {

    //other methods ...

    @Override
    public void undo() {
       fan.turnOn();
    }

}
```

implement undo method in TurnOnCommand
```java
public class TurnOffCommand implements Command {

    //other methods ...

    @Override
    public void undo() {
       fan.turnOff();
    }

}
```

add undo method and store last executed command in the remote
```java

public class FanRemote {
    
    private Command lastCommand;

    // other methods...

    public void execute(int i) {
        commands[i].execute();
        lastCommand = commands[i];
    }

    public void undo() {
        lastCommand.undo();
    }

}
```

testing code
```java
public void test3() {
        Fan fan = new Fan();
        FanRemote fanRemote = new FanRemote();
        TurnOnCommand turnOnCommand = new TurnOnCommand(fan);
        TurnOffCommand turnOffCommand = new TurnOffCommand(fan);
        fanRemote.set(0, turnOnCommand);
        fanRemote.set(1, turnOffCommand);
        fanRemote.execute(0);
        fanRemote.undo();
        fanRemote.execute(1);
        fanRemote.undo();
    }
```

output
```
turn on the fan
turn off the fan
turn off the fan
turn on the fan
```
