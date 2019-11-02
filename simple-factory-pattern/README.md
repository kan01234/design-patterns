# simple-factory-pattern
Project of example of simple factory pattern implement by Java. 

## What is simple factory pattern
creational pattern that uses factory methods to create objects without specify which class object that will be created.

class diagram:

![simple-factory-pattern](https://github.com/kan01234/design-patterns/blob/master/simple-factory-pattern/simple-factory-pattern.png)

1. Product
  - interface or abstract class that define Concrete Product

2. ProductA, Product B
  - concrete product need to create, classe that implement or extends product

3. SimpleFactory
  - class that have method to take parameter to create differents concrete product as needed

## When to use
- all of potential classes are in same subclass hierarchy
- centralize class creation
- encapsulate object creation

## Example
we have to create Hamburger by the order, and there are more type of hamburger will add later. Since we know there are more type of hamburger will add, so we seperate the create method to factory class.

class diagram:

![simple factory pattern example](https://github.com/kan01234/design-patterns/blob/master/simple-factory-pattern/simple-factory-pattern-example.png)

Hamburger, interface that define the product
```java
public interface Hamburger {
    public void pack();
    public boolean isVegetarian();
}
```

BeefHamburger, class that implement Hamburger, one of concrete products
```java
public class BeefHamburger implements Hamburger {
    @Override
    public void pack() {
        System.out.println("pack beef hamburger into paper box");
    }
    // other methods ....
}
```

FakeMeatHamburger, class that implment Hamburger, one of concrete products
```java
public class FakeMeatHamburger implements Hamburger {
    @Override
    public void pack() {
        System.out.println("pack fake meat hamburger with paper");
    }
    // other methods ....
}
```

SimpleHamburgerFactory, class that used to create concrete product and maintains factory method
```java
public class SimpleHamburgerFactory {
    public Hamburger makeHamburger(String order) {
        switch (order) {
            case "beef":
                return new BeefHamburger();
            case "fake meat":
                return new FakeMeatHamburger();
            default:
                return null;
        }
    }
}
```
And if there are more type of Hamburger are added, update the factory method

Testing code
```java
public void test() {
  SimpleHamburgerFactory hamburgerFactory = new SimpleHamburgerFactory();
  Hamburger beefHamburger = hamburgerFactory.makeHamburger("beef");
  Hamburger fakeMeatHamburger = hamburgerFactory.makeHamburger("fake meat");
  assertTrue(beefHamburger instanceof BeefHamburger);
  assertTrue(fakeMeatHamburger instanceof FakeMeatHamburger);
}
```

## Example (Pokemon)
Assume we need to create a Pokemon in run time or dynamically, and we are able to create Bulbasaur, Charmander and Squirtle.

class diagram:
![simple-factory-pattern](https://github.com/kan01234/design-patterns/blob/master/simple-factory-pattern/simple-factory-pattern-pokemon-1.png)

roles:

1. Pokemon is the Product
2. Bulbasaur, Charmander and Squirtle is the Concrete Product
3. SimplePokemonFactory is Simple Factory, using getPokemon(String) to create a Pokemon

Goods:
avoid the if else block shown as below:
```java
public static void main(String[] args) {
  String input = args[0]; // it's the Pokedex number from user
  Pokemon pokemon;
  if ("001".equals(input)) {
    pokemon = new Bulbasaur();
  } else if ("004".equals(input)) {
    pokemon = new Charmander();
  } else if ("007".equals(input)) {
    pokemon = new Squirtle();
  }
  // some other action....
}
```

in simple factory pattern, it would look like:
```java
public static void main(String[] args) {
  String input = args[0]; // it's the Pokedex number from user
  Pokemon pokemon = SimplePokemonFactory.getPokemon(input);
  // some other action....
}
```

To add a Concrete Product
Extend the above example, if we are going to add one more Pokemon Pikachu:

class diagram:
![simple-factory-pattern-2](https://github.com/kan01234/design-patterns/blob/master/simple-factory-pattern/simple-factory-pattern-pokemon-2.png)

as you can see on the class diagram, it need to add Pikachu class that implemet the Pokemon and modify the factory method in the SimplePokemonFactory.

### Cons
Since, it need to make a change to the existing code, and it will break the [Open-Closed Principle](https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle). So that, we can't said Simple Factory Pattern is a robust design pattern, but it is still useful in small software system architure architecture.
