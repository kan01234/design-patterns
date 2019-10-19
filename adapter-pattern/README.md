# adapter-pattern
Project of eample of adapter pattern implement by Java.

## What is adapter pattern

class diagram:

![adapter pattern](https://github.com/kan01234/design-patterns/blob/master/adapter-pattern/adapter-pattern.png)

To convert interface of class into another interface clients expected, there are 3 roles in adapter pattern:

1. Target
    the class clients needed

2. Adapter
    the class convert class to target class

3. Adaptee
    the class need a adapter to convert to Target class

## Example
Assume a zoo need 2 panda to display, but there are only one is avaiable, they try to use a part time work to be a fake Panda.

class diagram:

![adapter patten](https://github.com/kan01234/design-patterns/blob/master/adapter-pattern/adapter-pattern-example.png)

In above diagram
- Panda is the Target
- PandaAdapter is Adapter to convert PartTimeWorker to Panda
- PartTimeWorker is Adaptee

1. assume the panda can eat, sit and hello
```java
public interface Panda {

    public String eat();

    public String sit();

    public String hello();
}
```

2. class represent to real Panda
```java
public class PandaImpl implements Panda {
    // override methods...
}
```

3. class represent to part time worker
```java
public class PartTimeWorker {

    public String action(String action) {
        return "part time work, " + action;
    }

}
```

4. class convert part time worker to Panda, need to implement the Panda methods
```java
public class PandaAdapter implements Panda {

    private PartTimeWorker partTimeWorker;

    public PandaAdapter(PartTimeWorker partTimeWorker) {
        this.partTimeWorker = partTimeWorker;
    }

    @Override
    public String eat() {
        return partTimeWorker.action("fake eating");
    }

    @Override
    public String hello() {
        return partTimeWorker.action("wave the hands");
    }

    @Override
    public String sit() {
        return partTimeWorker.action("sit like a king");
    }

}
```

5. Client code
```java
    Panda panda = new PandaImpl();
    Panda fakePanda = new PandaAdapter(new PartTimeWorker());
    System.out.println("real panda");
    System.out.println(panda.eat());
    System.out.println(panda.sit());
    System.out.println(panda.hello());

    System.out.println("fake panda");
    System.out.println(fakePanda.eat());
    System.out.println(fakePanda.sit());
    System.out.println(fakePanda.hello());
```

6. and the output will like
```
real panda
lazy panda, eat Bamboo
lazy panda, goin to sleep
lazy panda, sleeping
fake panda
part time work, fake eating
part time work, sit like a king
part time work, wave the hands
```