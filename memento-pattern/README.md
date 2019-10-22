# memento-pattern
Project of eample of memento pattern implement by Java.

## What is memento pattern
Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.

class diagram:

![memento pattern](https://github.com/kan01234/design-patterns/blob/master/memento-pattern/memento-pattern.png)

there are 3 objects:

1. originator
    - object need to restore

2. memento
    - store data from originator need to be resotred

3. caretaker
    - handle memento object

steps:
1. originator create memento
2. caretaker take the memento
3. originator take some process
4. originator ask caretaker for memento
5. originator restore by the memento

## Example
Assume we are playing RPG game, we have a player and make save and load process

class diagram:

![memento pattern example](https://github.com/kan01234/design-patterns/blob/master/memento-pattern/memento-pattern-example.png)

Player is originator
```java
public class Player {

    private int hp;

    private int mp;

    private String state;

    public Player(int hp, int mp, String state) {
        this.hp = hp;
        this.mp = mp;
        this.state = state;
    }
    // getter, setter
}
```

Save is memento
```java
public class Save {

    private int hp;

    private int mp;

    private String state;

    // getter, setter

    public Save save() {
        return new Save(hp, mp, state);
    }

    public void load(Save save) {
        hp = save.getHp();
        mp = save.getMp();
        state = save.getState();
    }
}
```

SaveController is caretaker
```java
public class SaveController {

    private static final int MAX_NUM_OF_SAVE = 3;

    private Save[] saves = new Save[MAX_NUM_OF_SAVE];

    public Save getSave(int index) {
        return index < MAX_NUM_OF_SAVE ? saves[index] : null;
    }

    public boolean addSave(int index, Save save) {
        if (index >= MAX_NUM_OF_SAVE)
            return false;
        saves[index] = save;
        return true;
    }

}
```

create a new player with 100hp, 30mp, empty state and save to 0
```java
Player player = new Player(100, 30, "");
SaveController saveController = new SaveController();
System.out.println("new player: " + player);
System.out.println("save to 0");
saveController.addSave(0, player.save());
```

output
```
new player: Player [hp=100, mp=30, state=]
save to 0
```

after fight with monster, hp to 80, state to weak and save to 1
```java
System.out.println("fight with monster, get hurt");
player.setHp(80);
player.setState("weak");
System.out.println(player);
saveController.addSave(1, player.save());
```

output
```
fight with monster, get hurt
Player [hp=80, mp=30, state=weak]
save to 1
```

and then fight with boss, but player is dead
```java
System.out.println("fight with boss, dead");
player.setHp(0);
player.setState("dead");
System.out.println(player);
```

output
```
fight with boss, dead
Player [hp=0, mp=30, state=dead]
```

and you can choose save 0 or save 1 to continue the game
assume we load save 1 here
```java
System.out.println("load save 1");
player.load(saveController.getSave(1));
System.out.println(player);
```

```output
load save 1
Player [hp=80, mp=30, state=weak]
```