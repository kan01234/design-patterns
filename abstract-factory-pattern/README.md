# Abstract Factory Pattern
- like simple factory pattern but everything is encapsulated
- also build the field belong to that object
- allow to link not related objects in factory

## When To Use Abstract Factory Pattern
- allow to create related objects without specifying concrete product
- have many objects that can be added, change dynamically during runtime

## Example
Assume each Pokemon need a Move and Type when create it. now we have two type of Pokemon, Charmander and Pikachu. And the Pokemons will have difference type and move.

If we are using simple factory pattern, we will have many factories to create the Concrete Product (Type and Move), and it will more Pokemon added to the system.
And abstract factory pattern will change the factory concept in here:
1. factory still is a interface
2. factory is not only for one Type of Product, it will build Concrete Product needed for Pokemon

class diagram:
![abstract-factory-pattern](https://github.com/kan01234/design-patterns/blob/master/abstract-factory-pattern/abstract-factory-pattern-example.png)

Difference with simple factory pattern:
1. PokemonDetailsFactory able to build two type of Product, Type and Move
2. Instead of build difference type of Pokemon in single factory, each Pokemon will have their own factory and set the required field

### Bad
- get complicated
