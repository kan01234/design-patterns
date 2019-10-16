package com.dotterbear.abztract.factory.pattern.pokemon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimplePokemonFactoryTest {

  @Test
  public void TestBulbsasaur() {
    PokemonFactory pokemonFactory = new BulbasaurFactory();
    Pokemon bulbasasur = pokemonFactory.getPokemon();
    assertTrue(bulbasasur instanceof Bulbasaur);
    assertTrue(bulbasasur.getMove() instanceof Growl);
    assertTrue(bulbasasur.getType() instanceof Grass);
  }

  @Test
  public void TestCharmander() {
    PokemonFactory pokemonFactory = new CharmanderFactory();
    Pokemon charmander = pokemonFactory.getPokemon();
    assertTrue(charmander instanceof Charmander);
    assertTrue(charmander.getMove() instanceof Scratch);
    assertTrue(charmander.getType() instanceof Fire);
  }

  @Test
  public void TestSquirtle() {
    PokemonFactory pokemonFactory = new SquirtleFactory();
    Pokemon squirtle = pokemonFactory.getPokemon();
    assertTrue(squirtle instanceof Squirtle);
    assertTrue(squirtle.getMove() instanceof TailWhip);
    assertTrue(squirtle.getType() instanceof Water);
  }

  @Test
  public void TestPikachu() {
    PokemonFactory pokemonFactory = new PikachuFactory();
    Pokemon pikachu = pokemonFactory.getPokemon();
    assertTrue(pikachu instanceof Pikachu);
    assertTrue(pikachu.getMove() instanceof ThunderShock);
    assertTrue(pikachu.getType() instanceof Electric);
  }

}
