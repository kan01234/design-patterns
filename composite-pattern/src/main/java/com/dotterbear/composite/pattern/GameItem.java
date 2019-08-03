package com.dotterbear.composite.pattern;

public class GameItem extends Game {

    private String name;

    private int releaseYear;

    private String console;

    public GameItem(String name, int releaseYear, String console) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.console = console;
    }

	@Override
	public void displayInfo() {
		System.out.println("name: " + name + " | realase year: " + releaseYear + " | console: " + console);
	}

}