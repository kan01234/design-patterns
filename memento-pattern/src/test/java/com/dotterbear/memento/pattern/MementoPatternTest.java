package com.dotterbear.memento.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MementoPatternTest {

    @Test
    public void test() {
        Player player = new Player(100, 30, "");
        SaveController saveController = new SaveController();
        System.out.println("new player: " + player);
        System.out.println("save to 0");
        saveController.addSave(0, player.save());
        System.out.println("fight with monster, get hurt");
        player.setHp(80);
        player.setState("weak");
        saveController.addSave(1, player.save());
        System.out.println(player);
        System.out.println("save to 1");
        System.out.println("fight with boss, dead");
        player.setHp(0);
        player.setState("dead");
        System.out.println(player);
        System.out.println("load save 1");
        player.load(saveController.getSave(1));
        System.out.println(player);
        assertEquals(80, player.getHp());
        assertEquals("weak", player.getState());
    }

}