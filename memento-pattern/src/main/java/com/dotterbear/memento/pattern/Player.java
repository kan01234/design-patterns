package com.dotterbear.memento.pattern;

public class Player {

    private int hp;

    private int mp;

    private String state;

    public Player(int hp, int mp, String state) {
        this.hp = hp;
        this.mp = mp;
        this.state = state;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Save save() {
        return new Save(hp, mp, state);
    }

    public void load(Save save) {
        hp = save.getHp();
        mp = save.getMp();
        state = save.getState();
    }

    @Override
    public String toString() {
        return "Player [hp=" + hp + ", mp=" + mp + ", state=" + state + "]";
    }

}