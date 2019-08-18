# decorator-pattern
Project of eample of decorator pattern implement by Java.

## What is decorator pattern
allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class

class diagram:

![decorator pattern](https://github.com/kan01234/design-patterns/blob/master/decorator-pattern/decorator-pattern.png)

- Component
  - interface of target component

- ConcreteComponent
  - class of concrete component that implemts component interface

- ComponentDecorator
  - abstract class of component decorator that implements component interface

- ConcreteComponentDecorator
  - class of concrete component that extnds component decorator, and overwrite the method

## Example
Assume we are going to make Hamburger, each Hamburger need to have few Ingredients and prices.

class diagram:

![decorator pattern example](https://github.com/kan01234/design-patterns/blob/master/decorator-pattern/decorator-pattern-example.png)


- Hamburger is Component
- PlainHamburger is ConcreteComponent
- Hamburger is ComponentDecorator
- Beef and Onion is ConcreteComponentDecorator

Create Hamburger with Beef and Onion will like:
```java
Hamburger hamburger1 = new Onion(new Beef(new PlainHamburger()));
```
Each of the ConcreteComponentDecorator is respobile for add one ingredient and its own price to hamburger.

#### Good
- code is more easy to trace and understand, each of the concrete component decorator is only for simple function

#### Bad
- many of class will created for a simple function
