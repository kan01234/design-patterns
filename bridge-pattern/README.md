# bridge-pattern
Project of example of bridge pattern implement by Java. 

## What is bridge pattern
decouple an abstraction from its implementation so that the two can vary independently

class diagram:

![bridge pattern](https://github.com/kan01234/design-patterns/blob/master/bridge-pattern/bridge-pattern.png)

1. Implementation
    - interface that define implmentation needed

2. Concrete Implementation
    - class that implment Implementation, implement methods

3. Abstraction
    - interface that define the function need to have

4. Concrete Abstraction
    - class that implment Abstract, and implement function

## When to use bridge pattern
- want to decoupleing abstraction, implementation
- want abstraction, implementation can change independently

## Example
Assume we have a PS4 controller, and the controller can use for PS4 and steam console.

class diagram:

![bridge pattern example](https://github.com/kan01234/design-patterns/blob/master/bridge-pattern/bridge-pattern-example.png)

ControllerFunction, represent to implementation
```java
public interface ControllerFunction {
    public void joystickMove(String direction);
    public void pressHome();
}
```

PS4Function, represent to concrete implementation, class that implement PS4 functions
```java
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
```

SteamFunction, represent to concrete implementation, class that implement Steam function
```java
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
```

Controller, represent of abstraction
```java
public interface Controller {
    public void joystickMove(String direction);
    public void pressHome();
}
```

PS4Controller, represent of ConcreteAbstraction, when create PS4Controller, it need to take a ControllerFunction.
And when button pressed, it will call the ControllerFunction.
```java
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
```

Testing code

just replace the ControllerFunction when create PS4Controller, and it can use for difference consoles.
```java
Controller ps4ControllerWithPS4 = new PS4Controller(new PS4Function());
Controller ps4ControllerWithSteam = new PS4Controller(new SteamFunction());
System.out.println("move joystick up");
ps4ControllerWithPS4.joystickMove("up");
ps4ControllerWithSteam.joystickMove("up");
System.out.println("press ps button");
ps4ControllerWithPS4.pressHome();
ps4ControllerWithSteam.pressHome();
```

and the output like
```
move joystick up
move up
pressed up
press ps button
show PS4 home menu
unsupported button
```
