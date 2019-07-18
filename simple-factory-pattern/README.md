# Simple Factory Pattern
Creational pattern that uses factory methods to create objects without specify which class object that will be created.

From this points, a simple factory pattern will have 3 main roles shown as below:

## When to use
- all of potential classes are in same subclass hierarchy
- centralize class creation
- encapsulate object creation

1. Product
- should be interface or super class of Concrete Product

2. Concrete Product
- the object will be created by factory method

3. Simple Factory
- class to implement factory method to create Concrete Product]

## Example
Assume we need to create a Pokemon in run time or dynamically, and we are able to create Bulbasaur, Charmander and Squirtle.

class diagram:
![simple-factory-pattern](https://github.com/kan01234/design-patterns/blob/master/simple-factory-pattern/simple-factory-pattern-example.png)

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

### To add a Concrete Product
Extend the above example, if we are going to add one more Pokemon Pikachu:

class diagram:
![simple-factory-pattern-2](https://github.com/kan01234/design-patterns/blob/master/simple-factory-pattern/simple-factory-pattern-example-2.png)

as you can see on the class diagram, it need to add Pikachu class that implemet the Pokemon and modify the factory method in the SimplePokemonFactory. Since, it need to make a change to the existing code, and it will break the [Open-Closed Principle](https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle). So that, we can't said Simple Factory Pattern is a robust design pattern, but it is still useful in small software system architure architecture.
