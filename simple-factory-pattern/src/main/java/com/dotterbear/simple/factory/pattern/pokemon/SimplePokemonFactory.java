package com.dotterbear.simple.factory.pattern.pokemon;

public class SimplePokemonFactory {

  public static Pokemon getPokemon(String pokedexNum) {
    switch (pokedexNum) {
      case Bulbasaur.POKEDEX_NUM:
        return new Bulbasaur();
      case Charmander.POKEDEX_NUM:
        return new Charmander();
      case Squirtle.POKEDEX_NUM:
        return new Squirtle();
      case Pikachu.POKEDEX_NUM:
        return new Pikachu();
      default:
        return null;
    }
  }

}
