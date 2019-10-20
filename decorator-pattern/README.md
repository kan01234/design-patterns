# decorator-pattern
Project of eample of decorator pattern implement by Java.

## What is decorator pattern
allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class

class diagram:

![decorator pattern](https://github.com/kan01234/design-patterns/blob/master/decorator-pattern/decorator-pattern.png)

1. Component
    - interface of target component

2. Concrete Component
    - class of concrete component that implemts component interface

3. Component Decorator
    - abstract class of component decorator that implements component interface

4. Concrete Component Decorator
    - class of concrete component that extnds component decorator, and overwrite the method

![decorator pattern shape](https://github.com/kan01234/design-patterns/blob/master/decorator-pattern/decorator-pattern-shape.png)

we have base object, and add decorator 1 on top...

## Example
Assume we are going to make Hamburger, each Hamburger need to have few Ingredients and prices.

class diagram:

![decorator pattern example](https://github.com/kan01234/design-patterns/blob/master/decorator-pattern/decorator-pattern-example.png)

Hamburger is component
```java
public interface Hamburger {
    public List<String> getIngredients();
    public List<Integer> getPrices();
}
```

PlainHamburger is concrete component
```java
public class PlainHamburger implements Hamburger {
    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<String>();
        ingredients.add("plain bread");
        return ingredients;
    }
    @Override
    public List<Integer> getPrices() {
        List<Integer> prices = new ArrayList<Integer>();
        prices.add(5);
        return prices;
    }
}
```

HamburgerDecorator is component decorator
```java
public abstract class HamburgerDecorator implements Hamburger {
    private Hamburger hamburger;
    public HamburgerDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
    }
    @Override
    public List<String> getIngredients() {
        return hamburger.getIngredients();
    }
    @Override
    public List<Integer> getPrices() {
        return hamburger.getPrices();
    }
}
```

Beef, Onion are concrete compoonent decorator
```java
public class Beef extends HamburgerDecorator {
    public Beef(Hamburger hamburger) {
        super(hamburger);
    }
    @Override
    public List<String> getIngredients() {
        List<String> descriptions = super.getIngredients();
        descriptions.add("beef");
        return descriptions;
    }
    @Override
    public List<Integer> getPrices() {
        List<Integer> prices = super.getPrices();
        prices.add(30);
        return prices;
    }
}
```

```java
public class Onion extends HamburgerDecorator {
    public Onion(Hamburger hamburger) {
        super(hamburger);
    }
    @Override
    public List<String> getIngredients() {
        List<String> descriptions = super.getIngredients();
        descriptions.add("onion");
        return descriptions;
    }
    @Override
    public List<Integer> getPrices() {
        List<Integer> prices = super.getPrices();
        prices.add(8);
        return prices;
    }
}
```

Testing code, create Hamburger with Beef and Onion will like:
```java
Hamburger hamburger1 = new Onion(new Beef(new PlainHamburger()));
```
Each of the ConcreteComponentDecorator is respobile for add one ingredient and its own price to hamburger.

#### Good
- code is more easy to trace and understand, each of the concrete component decorator is only for simple function

#### Bad
- many of class will created for a simple function
