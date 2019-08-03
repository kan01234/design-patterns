package com.dotterbear.composite.pattern;

import org.junit.jupiter.api.Test;

public class CompositePatternTest {

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
        allGameType.displayInfo();
    }

}