# command-pattern
Project of eample of command pattern implement by Java. 

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
