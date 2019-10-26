# strategy-pattern
Project of eample of strategy pattern implement by Java.

## What is strategy pattern
Define family of behaviors, encapsulate each of them, make the interchangeable. let the behviors can be changed from clients that use it.

![strategy-pattern](https://github.com/kan01234/design-patterns/blob/master/strategy-pattern/strategy-pattern.png)

1. Strategy
    - interface that define the strategy method

2. Concrete Strategy
    - class that implements strategy method

3. Contxt
    - class that use the Strategy method for action

## When to use strategy pattern
- define a class will have one behavior that is similar to other behaviors in a list
- use the defined behaviors dynamically
- avoid duplicate code
- encapuslate the behavior 

## Exapmle
Assume the context is the Pokemon trainer in Pokemon GO.

And there are 3 items can thrown by the trainer:
1. regular Pokemon ball

![regualr](https://github.com/kan01234/design-patterns/blob/master/strategy-pattern/img/regular.png)

2. great ball

![great](https://github.com/kan01234/design-patterns/blob/master/strategy-pattern/img/great.png)

3. ultra ball

![ultra](https://github.com/kan01234/design-patterns/blob/master/strategy-pattern/img/ultra.png)

And there have 2 type of Trainer:
1. Beginner
2. Expert

And the Beginner is desired to use different types of Poke balls when they meet different type of Pokemon:
1. use regular Pokemon ball if it is normal Pokemon
2. use great ball if it is special Pokemon
3. use ultra ball if it is rare Pokemon

And the Expert is desired to use different types of Poke balls when they meet different type of Pokemon:
1. use great ball if it is normal Pokemon
2. use great ball if it is special Pokemon
3. use ultra ball if it is rare Pokemon

class diagram:
![strategy-pattern](https://github.com/kan01234/design-patterns/blob/master/strategy-pattern/%20strategy-pattern.png)
- Pokemon Trainer is Context
- ThrowStrategy is encapuslate action and interchangeable

ThrowStrategy interface
```java
public interface ThrowStrategy {

    public String throwItem();

}
```

ThrowRegualr, ThrowGreat, ThrowUltra are concrete strategy

ThrowRegular
```java
public class ThrowRegualr implements ThrowStrategy {

    public String throwItem() {
        return "throw regualr!";
    }

}
```

ThrowGreat
```java
public class ThrowGreat implements ThrowStrategy {

    public String throwItem() {
        return "throw great!";
    }

}
```

ThrowUltra
```java
public class ThrowUltra implements ThrowStrategy {

    public String throwItem() {
        return "throw ultra!";
    }

}
```

testing code
```java
beginner = new Beginner();
expert = new Expert();
String beginnerStr, expertStr;

// normal pokemon
System.out.println("see normal Pokemon");
beginnerStr = beginner.throwItem();
expertStr = expert.throwItem();
System.out.println("beginner " + beginnerStr);
System.out.println("expert " + expertStr);

// special pokemon
System.out.println("see special Pokemon");
beginner.setThrowStrategy(new ThrowGreat());
expert.setThrowStrategy(new ThrowUltra());
beginnerStr = beginner.throwItem();
expertStr = expert.throwItem();
System.out.println("beginner " + beginnerStr);
System.out.println("expert " + expertStr);

// rare pokemon
beginner.setThrowStrategy(new ThrowUltra());
expert.setThrowStrategy(new ThrowUltra());
beginnerStr = beginner.throwItem();
expertStr = expert.throwItem();
System.out.println("beginner " + beginnerStr);
System.out.println("expert " + expertStr);
```

output
```
see normal Pokemon
beginner throw regualr!
expert throw great!

see special Pokemon
beginner throw great!
expert throw ultra!

see rare Pokemon
beginner throw ultra!
expert throw ultra!
```

avoid coding like this:
```java
public class Beginner extends PokemonTrainer {
    // ...
    public String throwItem() {
        return "throw regular";
    }
}
```
```java
public class Expert extends PokemonTrainer {
    // ...
    public String throwItem() {
        return "throw great";
    }
}
```
