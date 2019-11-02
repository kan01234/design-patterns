# observer-pattern
Project of example of observer pattern implement by Java.

## What is observer pattern
in observer pattern, Subject will maintains list of observer and notify them when state changed.

class diagram:

![observer pattern](https://github.com/kan01234/design-patterns/blob/master/observer-pattern/observer-pattern.png)

1. Subject
    - interface that define subject need to observer
    - continas add/remove observer and notify observer when update

2. Concrete Subject
    - class that implements Subject
    - implement add/remove observer, and notify observer methods

3. Observer
    - interface that define observer of Subject
    - cotains update medthod, usually is call by Subject when notify

4. Concrete Observer
    - class that implements Observer
    - implment update mehotd

## When to use observer pattern
- when many object need to get notification when state changed
- loose coupling between the subject and observer

## Example
Assume you are a customer of a Shop, and you want to receive the promotion from the shop.
In this case, the shop promotion is the Subject, and the customer is the observer.

class diagram:

![observer pattern example](https://github.com/kan01234/design-patterns/blob/master/observer-pattern/observer-pattern-example.png)

Subject interface
```java
public interface Subject {

    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver(String data);
}
```

Concrete subject, ShoppingSubject
```java
public class ShoppingSubject implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String data) {
        observers.stream().forEach(observer -> observer.update(data));
    }

}
```

Observer interface
```java
public interface Observer {

    public void update(String data);

}
```

Customer, conrete observer
```java
public class Customer implements Observer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String data) {
        System.out.println(name + ": " + data + " is on sales");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
```

Testing code

two customer subscript to shopping subject
```java
    Subject subject = new ShoppingSubject();
    Observer observer1 = new Customer("peter");
    Observer observer2 = new Customer("mary");
    subject.addObserver(observer1);
    subject.addObserver(observer2);
```

shopping subject update cola
```java
subject.notifyObserver("cola");
```

output, both customer will recevie the updates
```
peter: cola is on sales
mary: cola is on sales
```

peter unsubscript to shopping subject

and shopping subject update soda
```java
subject.removeObserver(observer1);
subject.notifyObserver("soda");
```

only mary will receive the updates
```
mary: soda is on sales
```
