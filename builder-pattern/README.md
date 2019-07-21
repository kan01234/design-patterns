# builder-pattern
Project of eample of builder pattern implement by Java. 

## What is builder pattern
- used to create complex object
- separate construction code

class diagram:

![builder-pattern](https://github.com/kan01234/design-patterns/blob/master/builder-pattern/builder-pattern.png)

there are 4 roles in builder pattern:
1. Director

take Builder object, and have construct method to call step from the builder to create final product And it can get the final product after the construct method called.

2. Builder

abstract class or interface to define step needed to create a product correctly, and have a method to get a final product

3. ConcreteBuilder

class contain the implementation code to create product, it implement Builder methods  

4. Product

the final product class from the ConcreteBuilder

## When to use builder pattern
- avoid duplicate code for building a object
- create object independent from main process
- hide the creation code from client

## Example

class diagram:

![builder-pattern-example](https://github.com/kan01234/design-patterns/blob/master/builder-pattern/builder-pattern-example.png)

when the user need an Animal object, user do not need to take care how to create it, only use the product from the PetEngineer class.

## Goods
- code is highly readably
- reduce parameter needed to construct object
- easy to make an immutable object
- object is ready to use

## Bads
- number of lines of code increased
- number of classes increased, since need to have ConcreteBuilder of each product
