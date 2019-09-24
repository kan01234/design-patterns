# visitor-pattern
Project of eample of visitor pattern implement by Java.

## What is visitor pattern
- allow to define a new operation without changing the classes of the elements on which it operates
- way to follow the OCP

class diagram:

![visitor-pattern](https://github.com/kan01234/design-patterns/blob/master/visitor-pattern/visitor-pattern.png)

1. Element
    - interface for ConcreteELement, have method to take a Visitor

2. ConcreteElement
    - class implement Element

3. ObjectStructure
    - class for store all ConcreteElement

4. Visitor
    - interface defining vistor method for concrete element

5. ConcreteVisitor
    - class implement Visitor, and implment the action need to take

## Example
Assume we have a Robot toy, two type of user Kid and Repairman. They will take different action based on the Robot part.

class diagram:

![visitor-pattern-eample](https://github.com/kan01234/design-patterns/blob/master/visitor-pattern/visitor-pattern-example.png)

1. RobotElement is Element
2. RobotHead, RobotBody, RobotArm are ConcreteElement
3. Robot is ObjectStructure
4. RobotVisitor is Visitor
5. KidVisitor, RepairmanVisitor are ConcreteVisitor


to change the function needed, just use another visitor to same element
```java
public void RobotTest() {
    Robot robot = new Robot();
    System.out.println("KidVisitor");
    robot.accept(new KidVisitor());
    System.out.println("RepairmanVisitor");
    robot.accept(new RepairmanVisitor());
}
```


and the output will like
```
KidVisitor
RobotHead: say hello
RobotArm: hand shake
RobotBody: press the button
Robot: turn on/off robot
RepairmanVisitor
RobotHead: repair speaker
RobotArm: repair hand
RobotBody: repair button
Robot: change the battery
```

## When to use visitor pattern
continue from the above example, assume we only have RobotElement, RobotHead, RobotArm

asuume RobotHead, RobotArm have difference action, using visitor pattern can:
- avoid using the instanceof opeator
- add different action without updating Robot or RobotHead and RobotArm
- do not need to update Robot class if there are more RobotElement added

RobotElement.java
```java
public interface RobotElement {
    public String print();
}
```

RobotHead.java
```java
public class RobotHead {

    public String print() {
        return "RobotHead: ";
    }

    public void sayHello() {
        System.out.println(print() + "say hello");
    }

}
```

RobotArm.java
```java
public class RobotArm {

    public String print() {
        return "RobotArm: ";
    }

    public void HandShake() {
        System.out.println(print() + "hand shake");
    }

}
```

Robot.java
```java
public class Robot {

    List<RobotElement> robotElements;

    public Robot() {
        robotElements = Arrays.asList(new RobotHead(), new RobotArm());
    }

    public void action() {
        for (RobotElement robotElement : robotElements) {
            if (robotElement instanceof RobotHead) {
                ((RobotHead) robotElement).sayHello();
            } else if (robotElement instanceof RobotHead) {
                ((RobotArm) robotElement).HandShake();
            }
            // more instanceof if more concrete element ...
        }
    }

}
```
