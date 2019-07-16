package com.dotterbear.abztract.factory.pattern;

public class SquirtleFactory implements PokemonFactory {

  private static PokemonDetailsFactory detailsFactory = new SquirtleDetailsFactory();

  @Override
  public Pokemon getPokemon() {
      Pokemon pokemon = new Squirtle();
      pokemon.setMove(detailsFactory.getMove());
      pokemon.setType(detailsFactory.getType());
      return pokemon;
  }

}
