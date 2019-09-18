package com.dotterbear.strategy.pattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class StrategyPatternTest {

  PokemonTrainer beginner;
  PokemonTrainer expert;
  String beginnerStr;
  String expertStr;

  @BeforeEach
  public void beforeEach() {
    beginner = new Beginner();
    expert = new Expert();
    beginnerStr = null;
    expertStr = null;
    System.out.println("- - - -");
  }

  @AfterEach
  public void AfterEach() {
    System.out.println("beginner " + beginnerStr);
    System.out.println("expert " + expertStr);
  }

  @Test
  public void TestNormalPokemon() {
    System.out.println("see normal Pokemon");
    beginnerStr = beginner.throwItem();
    expertStr = expert.throwItem();
    assertEquals("throw regualr!", beginnerStr);
    assertEquals("throw great!", expertStr);
  }

  @Test
  public void TestSpecialPokemon() {
    System.out.println("see special Pokemon");
    beginner.setThrowStrategy(new ThrowGreat());
    expert.setThrowStrategy(new ThrowUltra());
    beginnerStr = beginner.throwItem();
    expertStr = expert.throwItem();
    assertEquals("throw great!", beginnerStr);
    assertEquals("throw ultra!", expertStr);
  }

  @Test
  public void TestRarePokemon() {
    System.out.println("see rare Pokemon");
    beginner.setThrowStrategy(new ThrowUltra());
    expert.setThrowStrategy(new ThrowUltra());
    beginnerStr = beginner.throwItem();
    expertStr = expert.throwItem();
    assertEquals("throw ultra!", beginnerStr);
    assertEquals("throw ultra!", expertStr);
  }

}
