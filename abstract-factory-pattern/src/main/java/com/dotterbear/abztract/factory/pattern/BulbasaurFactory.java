package com.dotterbear.abztract.factory.pattern;

public class BulbasaurFactory implements PokemonFactory {

  private static PokemonDetailsFactory detailsFactory = new BulbasaurDetailsFactory();

  @Override
  public Pokemon getPokemon() {
      Pokemon pokemon = new Bulbasaur();
      pokemon.setMove(detailsFactory.getMove());
      pokemon.setType(detailsFactory.getType());
      return pokemon;
  }

}
