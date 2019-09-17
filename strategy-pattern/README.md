# strategy-pattern
Project of eample of strategy pattern implement by Java.

## What is strategy pattern
Define family of behaviors, encapsulate each of them, make the interchangeable. let the behviors can be changed from clients that use it.

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
