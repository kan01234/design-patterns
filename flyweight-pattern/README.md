# flyweight-pattern
Project of eample of flyweight pattern implement by Java.

## What is flyweight pattern
minmizes memory usage by sharing as much data as possible with other objects

class diagram;

![flyweight-pattern](https://github.com/kan01234/design-patterns/blob/master/flyweight-pattern/flyweight-pattern.png)

1. Flyweight
    - abstract class or interface for ConcreteFlyweight

2. Concrete Flyweight
    - concrete prodcut of object, implment sharing state and data here

3. Flyweight Factory
    - class that create and manage sharing flyweight here

4. Client
    - class that use the concrete flyweight object

## Example
Assume we are having a restaurant, and that restaurant can do any food or drink ordered by the customer.
And after first order, the new item should be added to the menu.
It should not create a new menu item evey time.
Also all of the Food is unable to take away, so it will have shared value.

class diagram:

![flyweight-pattern-example](https://github.com/kan01234/design-patterns/blob/master/flyweight-pattern/flyweight-pattern-example.png)

3. Menu is FlyweightFactory

MenuItem represent to flyweight
```java
public abstract class MenuItem {

    protected String name;

    protected int price;

    public abstract void order();

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
```

Food represent to concrete flyweight

have share internal data TAKE_AWAY
```java
public class Food extends MenuItem {

    protected final boolean TAKE_AWAY = false;

    public Food(String name, int price) {
        super(name, price);
    }

    @Override
    public void order() {
        System.out.println("order food: " + name + ", price: " + price + ", can take away: " + TAKE_AWAY);
    }

}
```

Menu represent to flyweight factory

have a map to store MenuItem, and create it if not found
```java
public class Menu {

    public static final Map<String, MenuItem> MENU = new HashMap<>();

    public MenuItem order(String name, boolean isFood) {
        return MENU.computeIfAbsent(name, n -> {
            System.out.println("creating menu item: "+ n);
            int price = (int) (Math.random() * 100);
            return isFood ? new Food(n, price) : new Drink(name, price);
        });
    }

}
```

Testing code

and menuItem1 will equal to menuItem2, because both of them is cole
```java
@Test
public void test() {
    Menu menu = new Menu();
    MenuItem menuItem1, menuItem2;
    menuItem1 = menu.order("cole", false);
    menuItem2 = menu.order("cole", false);
    assertTrue(menuItem1 == menuItem2);
    menuItem1 = menu.order("sushi", true);
    menuItem2 = menu.order("ramen", true);
    menuItem1.order();
    menuItem2.order();
}
```

output:

cole is only create once
```
creating menu item: cole
creating menu item: sushi
creating menu item: ramen
order food: sushi, price: 33, can take away: false
order food: ramen, price: 56, can take away: false
```
