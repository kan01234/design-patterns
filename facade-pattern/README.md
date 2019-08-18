# facade-pattern
Project of eample of facade pattern implement by Java.

## What is facade pattern
facade object define a higher-level interface that makes subsystem easier to use

class diagram:

![facade pattern](https://github.com/kan01234/design-patterns/blob/master/facade-pattern/facade-pattern.png)

1. Class1, Class2, Class3 are sub system code
2. Facade is object define higher-level function by calling sub system code
3. Client use Facade object

Example:

Class1, Class2, Class3 have difference fn need to be called for the goal

the client will call method like:
```java
Class1 c1 = new Class1();
Class1 c2 = new Class2();
Class1 c3 = new Class3();
c3.fn1();
c2.fn1();
c1.fn1();
c1.fn2();
```

the above code maybe is hard to read and call by the Client, so we can have a facade object and pack the above code in a method.

Facade object
```java
public class Facade {
    public void do() {
        Class1 c1 = new Class1();
        Class1 c2 = new Class2();
        Class1 c3 = new Class3();
        c3.fn1();
        c2.fn1();
        c1.fn1();
        c1.fn2();
    }
}
```

And the Client able to reach the goal by
```java
Facade facade = new Facade();
facade.do();
```

## When to use facade pattern
- improve readability and usability
- provide more generic function
- provide entry point for monolithiic or tighty-coupled system of loosely-coupled code

## Example
Assume we are need to serve a breakfast with egg, bacon and english muffin, and need to handle the food with difference step.

class diagram:

![facade-pattern-example](https://github.com/kan01234/design-patterns/blob/master/facade-pattern/facade-pattern-example.png)

1. BreakfastFacade is facade object
2. Egg, Bacon, EnglishMuffin are sub system code
3. Test is Client

for every breakfast, need to prepare like below step
1. cut muffin
2. hot muffin
3. cook bacon
4. open egg
5. mix egg
6. cook egg

we have server() method in BreakfastFacade, and the client only need to call that method instead of call the others follow step by step
```java
public class BreakfastFacade {

    // other fields init

    public void serve() {
        englishMuffin.cut();
        englishMuffin.hot();
        bacon.cook();
        egg.open();
        egg.mix();
        egg.cook();
    }

}
```

output:
```
cut the muffin
hot the muffix
cook the bacon
open the eggs
mix the eggs
make scrambled eggs
```
