# iterator-pattern
Project of eample of iterator pattern implement by Java. 

## What is iterator pattern
provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation

class diagram:

![iterator pattern](https://github.com/kan01234/designs-patterns/blob/master/iterator-pattern/iterator-pattern.png)

1. Aggregate
    - interface for create iterator

2. ConcreteAggregate
    - class that implements Aggregate, and implementation of collection of objects

3. Iterator
    - interface for access elements

4. ConcreteIterator
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

1. MenuItem
    - object of concrete product

2. MenuIterator
    - interface for menu iterator

3. FoodMenuIterator, DrinkMenuIterator
    - concrete iterator impelement MenuInterator

4. Menu
    - aggregate of menu

5. FoodMenu, DrinkMenu
    - concrete aggregate thant contains foods and drinks

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
