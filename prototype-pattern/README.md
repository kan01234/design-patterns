# prototype-pattern
Project of eample of prototype pattern implement by Java.

## What is prototype pattern
creating new object by clone a object.

class diagram:

![prototype pattern](https://github.com/kan01234/design-patterns/blob/master/prototype-pattern/prototype-pattern.png)

1. Prototype
    - interface of prototype
    - have make copy method

2. Concrete Prototype
    - class that implment prototype
    - implment make copy method

## When to use prototype pattern
avoid the inherent cost of creating a new object in the standard way, for example new object need to fetch data from database

## Example
Assume we have two type of Animal, but it need so many time to wait for Animal grow up, so it would be better if we can clone a Animal instead of new another one.

![prototype pattern example](https://github.com/kan01234/design-patterns/blob/master/prototype-pattern/prototype-pattern-example.png))

Animal, prototype interface

make it simple, just extends Cloneable class in Java
```java
public interface Animal extends Cloneable {

    public Animal makeCopy();

}
```

Sheep, Pig are ConcretePrototype
```java
public class Sheep implements Animal {

    public Sheep() {
        System.out.println("new Sheep");
    }

    public Animal makeCopy() {
        System.out.println("making a Sheep copy");
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }

}
```

Pig
```java
public class Pig implements Animal {

    public Pig() {
        System.out.println("new Pig");
    }

    public Animal makeCopy() {
        System.out.println("making a Pig copy");
        Pig pig = null;
        try {
            pig = (Pig) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return pig;
    }

}
```

test code
```java
Animal sheep = new Sheep();
Animal sheepCopy = sheep.makeCopy();
assertFalse(sheep.equals(sheepCopy));
```

output will like
```
new Sheep
making a Sheep copy
```

sheep is difference object with sheepCopy