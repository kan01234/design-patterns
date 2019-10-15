package com.dotterbear.simple.factory.pattern.pokemon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimplePokemonFactoryTest {

  @Test
  public void test() {
    Pokemon pokemon;
    pokemon = SimplePokemonFactory.getPokemon("");
    assertEquals(null, pokemon);
    pokemon = SimplePokemonFactory.getPokemon(Bulbasaur.POKEDEX_NUM);
    assertTrue(pokemon instanceof Bulbasaur);
    pokemon = SimplePokemonFactory.getPokemon(Charmander.POKEDEX_NUM);
    assertTrue(pokemon instanceof Charmander);
    pokemon = SimplePokemonFactory.getPokemon(Squirtle.POKEDEX_NUM);
    assertTrue(pokemon instanceof Squirtle);
    pokemon = SimplePokemonFactory.getPokemon(Pikachu.POKEDEX_NUM);
    assertTrue(pokemon instanceof Pikachu);
  }

}
