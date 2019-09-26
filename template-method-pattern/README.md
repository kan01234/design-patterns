# template-method-pattern
Project of eample of template method pattern implement by Java.

## What is template method pattern
- template method is an method defined in super class, deifning the high-level steps, and it can not be ovrerride
- stepes is implemented by the hepler method from the same class
  - there are two type of helper methods, abstract method or hook method

1. abstract method
    - method need to implement by the child class

2. hook method
    - method can override, but not requiree to implement to refine the high-level steps

class diagram:

![templat method pattern](https://github.com/kan01234/design-patterns/blob/master/template-method-pattern/template-method-pattern.png)

## Example
Assume there are 3 type of Pizza, and the steps to make the Pizza is shown below:

|step|Pizzz A|Pizza B|Pizza C|
|-|---|---|---|
|dough|pizza dough|pizza dough| pizza dough|
|add sauce|tomato|bbq|bbq|
|add meat|ham|bacon|skip|
|add vegetable|onion|mushrooms|mushrooms|
|add cheese|mozzarella|parmesan|parmesan|
|bake|Yes|Yes|Yes|
|cut|Yes|Yes|Yes|

class diagram:

![templat method pattern example](https://github.com/kan01234/design-patterns/blob/master/template-method-pattern/template-method-pattern-example.png)

- Pizza is the abstract class
    - makePizza is the tempalte method
    - isVegetarian is the hook method to control is addMeat will be called
    - addSauce addMeat, addVegetable are the abstract method implement by the child class
- CustomPizzaC need to skip the addMeat step
    - override isVegetarian method to skip

Notes:

```java
public abstract class Pizza {

    public final void makePizza() {
        makeDough();
        addSauce();
        addCheese();
        if (!isVegetarian())
            addMeat();
        addVegetable();
        bakePizza();
        cutPizza();
    }

    public void makeDough() {
        System.out.println("make pizza dough");
    }

    public void bakePizza() {
        System.out.println("bake pizza");
    }

    public void cutPizza() {
        System.out.println("cut pizza");
    }

    public abstract void addMeat();

    public abstract void addVegetable();

    public abstract void addSauce();

    public abstract void addCheese();

    public boolean isVegetarian() {
        return false;
    }

}
```

1. template method, makePizza() need to be final, avoid override by child class
2. common step can be store in abstract class, like makeDough, bakePizza, cutPizza
3. isVegetarian is hook method can override by child class
4. do not call hook method in lower level class from high level class, it will make dependencies between high-level class and lower-level class, hard to understand relationship between the classes 
