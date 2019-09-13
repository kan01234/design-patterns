# prototype-pattern
Project of eample of prototype pattern implement by Java.

## What is prototype pattern
creating new object by clone a object.

class diagram:

![prototype pattern](https://github.com/kan01234/design-patterns/blob/master/design-patterns/prototype-pattern.png)

- Prototype
    - prototype of object

- ConcretePrototype
    - subclass of prototype

- Client
    - use Prototype to clone object

## When to use prototype pattern
avoid the inherent cost of creating a new object in the standard way, for example new object need to fetch data from database

## Example
Assume we have two type of Animal, but it need so many time to wait for Animal grow up, so it would be better if we can clone a Animal instead of new another one.

![prototype pattern example](https://github.com/kan01234/design-patterns/blob/master/design-patterns/prototype-pattern-example.png))

- Animal, is Prototype
- Sheep, Pig are ConcretePrototype
- Test, is Client

Sheep.java
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

test code
```java
    public void AnimalTest() {
        Animal sheep = new Sheep();
        Animal sheepCopy = sheep.makeCopy();
        assertFalse(sheep.equals(sheepCopy));
    }
```

output will like
```
new Sheep
making a Sheep copy
```

sheep is difference object with sheepCopy