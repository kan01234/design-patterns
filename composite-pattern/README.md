# composite-pattern
Project of example of composite pattern implement by Java.

## What is composite pattern
- allow to treat individual object and compositions uniformly
- allow to represent part-whole hierarchies
- objects in tree structures and able to divided into smaller components
- describe a group of object that is treated the same way as a single instance of same type of object

structure:

![structure](https://github.com/kan01234/design-patterns/blob/master/composite-pattern/composite-pattern-structure.png)

class diagram:

![composite-pattern](https://github.com/kan01234/design-patterns/blob/master/composite-pattern/composite-pattern.png)

1. Component
    - abstract class or interface for Composite and Leaf

2. Composite
    - class instance of Component
    - a composite object that able to contains Leaf
    - implment all Component methods

3. Leaf
    - class instance of Component
    - leaft object in the composition

## Example
Assume we are having a game list and showing the games information by type.

And the game data like

|Name|Type|
|---|---|
|Pocket Monsters Red and Green|Pokémon|
|Pocket Monsters Blue|Pokémon|
|Pokémon Red and Blue|Pokémon|
|fifa18|Sport|
|nba2k20|Sport|

If we need to display the games by type, we need to
```java
Map<String, List<Game>> gamesListMap;
for(String key : gameListMap.keySet()) {
    System.out.println("name: " + key)
    for(Game game : gameListMap.get(key)) {
        System.out.println("name: " + game.getName());
    }
}
```
but the above code is hard to maintenance, and it need to change if more sub type added.

class diagram:

![composite-pattern-example](https://github.com/kan01234/design-patterns/blob/master/composite-pattern/composite-pattern-example.png)

1. Game is Component
2. GameItem is Leaft
3. GameType is Composite
4. Test is Client

Game
```java
public abstract class Game {

    public abstract void displayInfo();

}
```

GameItem
```java
public class GameItem extends Game {
    
    // other methods...

	@Override
	public void displayInfo() {
		System.out.println("name: " + name + " | realase year: " + releaseYear + " | console: " + console);
	}

}
```

GameType
```java
public class GameType extends Game {

    private List<Game> games;
 
    // other methods...

    @Override
    public void displayInfo() {
        System.out.println("----");
        System.out.println("name: " + name);
        System.out.println("desc:" + desc);
        for (Game game : games)
            game.displayInfo();
    }

}
```

Testing code
```java
@Test
public void test() {
    GameType allGameType = new GameType("all", "game type contains all available games");
    GameType pokemonGameType = new GameType("pokemon", "game type contains pokemon games");
    GameType sportGameType = new GameType("sport", "game type contains sport games");
    allGameType.add(pokemonGameType);
    allGameType.add(sportGameType);
    pokemonGameType.add(new GameItem("Pocket Monsters Red and Green", 1996, "Game Boy"));
    pokemonGameType.add(new GameItem("Pocket Monsters Blue", 1999, "Game Boy"));
    pokemonGameType.add(new GameItem("Pokémon Red and Blue", 1998, "Game Boy"));
    sportGameType.add(new GameItem("fifa18", 2017, "PS4"));
    sportGameType.add(new GameItem("nba2k20", 2019, "PS4"));
}
```

display all games information
```java
allGameType.displayInfo();
```

output
```
----
name: all
desc:game type contains all available games
----
name: pokemon
desc:game type contains pokemon games
name: Pocket Monsters Red and Green | realase year: 1996 | console: Game Boy
name: Pocket Monsters Blue | realase year: 1999 | console: Game Boy
name: Pokémon Red and Blue | realase year: 1998 | console: Game Boy
----
name: sport
desc:game type contains sport games
name: fifa18 | realase year: 2017 | console: PS4
name: nba2k20 | realase year: 2019 | console: PS4
```

display sport game information
```java
sportGameType.displayInfo();
```

output
```
----
name: sport
desc:game type contains sport games
name: fifa18 | realase year: 2017 | console: PS4
name: nba2k20 | realase year: 2019 | console: PS4
```
