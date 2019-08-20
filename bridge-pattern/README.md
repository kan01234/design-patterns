# bridge-pattern
Project of eample of bridge pattern implement by Java. 

## What is bridge pattern
decouple an abstraction from its implementation so that the two can vary independently

class diagram:

![bridge pattern](https://github.com/kan01234/design-patterns/blob/master/bridge-pattern/bridge-pattern.png)

- Implementation interface to define implmentation needed
- ConcreteImplementation implement methods in Implementation interface
- Abstraction define function will use
- ConcreteAbstraction can custom other functions, and use implmentation from ConreteImplementation

## When to use bridge pattern
- want to decoupleing abstraction, implementation
- want abstraction, implementation can change independently

## Example
Assume we have a PS4 controller, and the controller can use for PS4 and steam console.

class diagram:

![bridge pattern example](https://github.com/kan01234/design-patterns/blob/master/bridge-pattern/bridge-pattern-example.png)

- Controller is the Abstraction
- PS4Controller is the ConcreteAbstraction
- ControllerFunction is the Implementation
- PS4Function, SteamFunction is the ConcreteImplementation

just replace the ControllerFunction when create PS4Controller, and it can use for difference consoles.
```java
public void ControllerTest() {
    Controller ps4ControllerWithPS4 = new PS4Controller(new PS4Function());
    Controller ps4ControllerWithSteam = new PS4Controller(new SteamFunction());
    System.out.println("move joystick up");
    ps4ControllerWithPS4.joystickMove("up");
    ps4ControllerWithSteam.joystickMove("up");
    System.out.println("press ps button");
    ps4ControllerWithPS4.pressHome();
    ps4ControllerWithSteam.pressHome();
}
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
