# Abstract Factory Pattern
- like simple factory pattern but everything is encapsulated
- also build the field belong to that object
- allow to link not related objects in factory

class diagram:

![abstract-factory-pattern](https://github.com/kan01234/design-patterns/blob/master/abstract-factory-pattern/abstract-factory-pattern.png)

1. AbstractProductA, AbstractProductB
    - abstract class or interface to define the Product

2. ProductA1, ProductA2, ProductB1, ProductB2
    - classes that implement or extends AbstractProduct
    - concrete product

3. AbstractFactory
    - interface that define the factory method

4. Factory1, Factory2
    - classes implement AbstractFactory, implement factory method
    - by switching Factory1 and Factory2, we can create different AbstractProductA and AbstractProductB

## When To Use Abstract Factory Pattern
- allow to create related objects without specifying concrete product
- have many objects that can be added, change dynamically during runtime

## Example
we have to make fast food including hamburger and nugget. But we need to make provide fast food to normal fast food shop and vegetarian fast food shop.

class diagram:

![abstract factory pattern example](https://github.com/kan01234/design-patterns/blob/master/abstract-factory-pattern/abstract-factory-pattern-example.png)

Hamburger interface
```java
public interface Hamburger {
    public void pack();
    public boolean isVegetarian();
}
```

BeefHamburger
```java
public class BeefHamburger implements Hamburger {
    @Override
    public void pack() {
        System.out.println("pack beef hamburger into paper box");
    }
    @Override
    public boolean isVegetarian() {
        return false;
    }
}
```

FakeMeatHamburger
```java
public class FakeMeatHamburger implements Hamburger {
    @Override
    public void pack() {
        System.out.println("pack fake meat hamburger with paper");
    }
    @Override
    public boolean isVegetarian() {
        return true;
    }
}
```

Nugget
```java
public interface Nugget {
    public void fired();
    public void pack();
    public boolean isVegetarian();
}
```

ChickenNugget
```java
public class ChickenNugget implements Nugget {
    @Override
    public void fired() {
        System.out.println("fired chicken nugget for 6 minutes");
    }
    @Override
    public void pack() {
        System.out.println("pack 6 pieces of chicken nugget into box");
    }
    @Override
    public boolean isVegetarian() {
        return false;
    }
}
```

FakeMeatNugget
```java
public class FakeMeatNugget implements Nugget {
    @Override
    public void fired() {
        System.out.println("fired fake meat nugget for 3 minutes");
    }
    @Override
    public void pack() {
        System.out.println("pack 9 pieces of fake meat nugget into box");
    }
    @Override
    public boolean isVegetarian() {
        return true;
    }
}
```

FastFoodFactory
```java
public interface FastFoodFactory {
    public Hamburger createHamburger();
    public Nugget createNugget();
}
```

NormalFastFoodFactory, class to create normal fast food
```java
public class NormalFastFoodFactory implements FastFoodFactory {
    @Override
    public Hamburger createHamburger() {
        return new BeefHamburger();
    }
    @Override
    public Nugget createNugget() {
        return new ChickenNugget();
    }
}
```

VegetarianFastFoodFactory, class to create vegetarian fast food
```java
public class VegetarianFastFoodFactory implements FastFoodFactory {
    @Override
    public Hamburger createHamburger() {
        return new FakeMeatHamburger();
    }
    @Override
    public Nugget createNugget() {
        return new FakeMeatNugget();
    }
}
```

Testing code for create normal fast food
```java
FastFoodFactory fastFoodFactory = null;
Hamburger hamburger = null;
Nugget nugget = null;
// make normal fast food
fastFoodFactory = new NormalFastFoodFactory();
hamburger = fastFoodFactory.createHamburger();
nugget = fastFoodFactory.createNugget();
assertFalse(hamburger.isVegetarian());
assertFalse(nugget.isVegetarian());
```

Testing code for create vegetarian fast food
```java
// make vegetarian fast food
fastFoodFactory = new VegetarianFastFoodFactory();
hamburger = fastFoodFactory.createHamburger();
nugget = fastFoodFactory.createNugget();
assertTrue(hamburger.isVegetarian());
assertTrue(nugget.isVegetarian());
```

by switching differents concrete factory class, we can create different Hamburger and Nugget

## Example (Pokemon)
Assume each Pokemon need a Move and Type when create it. now we have two type of Pokemon, Charmander and Pikachu. And the Pokemons will have difference type and move.

If we are using simple factory pattern, we will have many factories to create the Concrete Product (Type and Move), and it will more Pokemon added to the system.
And abstract factory pattern will change the factory concept in here:
1. factory still is a interface
2. factory is not only for one Type of Product, it will build Concrete Product needed for Pokemon

class diagram:
![abstract-factory-pattern-example](https://github.com/kan01234/design-patterns/blob/master/abstract-factory-pattern/abstract-factory-pattern-pokemon.png)

Difference with simple factory pattern:
1. PokemonDetailsFactory able to build two type of Product, Type and Move
2. Instead of build difference type of Pokemon in single factory, each Pokemon will have their own factory and set the required field

### Bad
- get complicated
