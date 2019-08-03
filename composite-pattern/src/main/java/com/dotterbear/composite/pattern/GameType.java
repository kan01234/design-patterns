package com.dotterbear.composite.pattern;

import java.util.ArrayList;
import java.util.List;

public class GameType extends Game {

    private String name;

    private String desc;

    private List<Game> games;

    public GameType(String name, String desc) {
        games = new ArrayList<>();
        this.name = name;
        this.desc = desc;
    }

    @Override
    public void add(Game game) {
        games.add(game);
    }

    @Override
    public Game getGame(int index) {
        return games.get(index);
    }

    @Override
    public void remove(Game game) {
        games.remove(game);
    }



    @Override
    public void displayInfo() {
        System.out.println("----");
        System.out.println("name: " + name);
        System.out.println("desc:" + desc);
        for (Game game : games)
            game.displayInfo();
    }

}