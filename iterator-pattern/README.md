# iterator-pattern
Project of example of iterator pattern implement by Java. 

## What is iterator pattern
provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation

class diagram:

![iterator pattern](https://github.com/kan01234/design-patterns/blob/master/iterator-pattern/iterator-pattern.png)

1. Aggregate
    - interface for create iterator

2. Concrete Aggregate
    - class that implements Aggregate, and implementation of collection of objects

3. Iterator
    - interface for access elements

4. Concrete Iterator
    - class that implments Iterator, and implementation to access the collecion of ConcreteAggregate

## Example
Assume have a resturant, displaying foods and drink in difference menu. Storing foods by List and storing the foods by array.
And print the menu by below methods:

```java
void printMenu(List<MenuItem> foods) {
    // implementation
}

void printMenu(MenuItem[] drinks){
    // implementation
}
```

However, if there are more difference type of storing, we need to add more method to handle it?

class diagram:

![iterator pattern](https://github.com/kan01234/design-patterns/blob/master/iterator-pattern/iterator-pattern-example.png)

MenuItem is concrete product
```java
public class MenuItem {
    private String name;
    private int price;
    // getter, setter methods
}
```

MenuIterator is iterator
```java
public interface MenuIterator {
    public boolean hasNext();
    public MenuItem next();
}
```

FoodMenuIterator is concrete iterator
```java
public class FoodMenuIterator implements MenuIterator {

    private List<MenuItem> foods;

    private int cur;

    public FoodMenuIterator(List<MenuItem> foods) {
        this.foods = foods;
        cur = 0;
    }

	@Override
    public boolean hasNext() {
        return foods != null && cur < foods.size();
    }

    @Override
    public MenuItem next() {
        return foods.get(cur++);
    }

}
```

DrinkMenuIterator is concrete iterator
```java
public class DrinkMenuIterator implements MenuIterator {

    private MenuItem[] drinks;

    private int cur;

    public DrinkMenuIterator(MenuItem[] drinks) {
        this.drinks = drinks;
        cur = 0;
    }

    @Override
    public boolean hasNext() {
        return drinks != null && cur < drinks.length;
    }

    @Override
    public MenuItem next() {
        return drinks[cur++];
    }

}
```

Menu is aggregate
```java
public interface Menu {

    public MenuIterator createIterator();

}
```

print foods and drink

without iterator
```java
MenuItem[] drinks = new MenuItem[] {
    new MenuItem("cole", 10),
    new MenuItem("beer", 18),
    new MenuItem("water", 3)
};
List<MenuItem> foods = Arrays.asList(
    new MenuItem("ramen", 98),
    new MenuItem("sushi", 68)
);
for (MenuItem drink : drinks)
    System.out.println(drink);
for (MenuItem food : foods)
    System.out.println(food);
```

using menu iterator
```java
public void test() {
    // int foods and drinks data
    Menu foodMenu = new FoodMenu(foods);
    Menu drinkMenu = new DrinkMenu(drinks);
    printMenu(foodMenu.createIterator());
    printMenu(drinkMenu.createIterator());
}

public void printMenu(MenuIterator menuIterator) {
    while(menuIterator.hasNext()) {
        MenuItem item = menuIterator.next();
        System.out.println(item);
    }
}
```

output
```
MenuItem [name=ramen, price=98]
MenuItem [name=sushi, price=68]
MenuItem [name=cole, price=10]
MenuItem [name=beer, price=18]
MenuItem [name=water, price=3]
```
