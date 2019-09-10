# observer-pattern
Project of eample of observer pattern implement by Java.

## What is observer pattern
in observer pattern, Subject will maintains list of observer and notify them when state changed.

class diagram:

![observer pattern](https://github.com/kan01234/design-patterns/blob/master/observer-pattern/observer-pattern.png)

## When to use observer pattern
- when many object need to get notification when state changed
- loose coupling between the subject and observer

## Example
Assume you are a customer of a Shop, and you want to receive the promotion from the shop.
In this case, the shop promotion is the Subject, and the customer is the observer.

class diagram:

![observer pattern example](https://github.com/kan01234/design-patterns/blob/master/observer-pattern/observer-pattern-example.png)

```java
    Subject subject = new ShoppingSubject();
    Observer observer1 = new Customer("peter");
    Observer observer2 = new Customer("mary");
    subject.addObserver(observer1);
    subject.addObserver(observer2);
    subject.notifyObserver("cola");
    subject.removeObserver(observer1);
    subject.notifyObserver("soda");
```

And the output will like
```bash
peter: cola is on sales
mary: cola is on sales
mary: soda is on sales
```
