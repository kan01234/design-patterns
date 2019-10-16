package com.dotterbear.abztract.factory.pattern.pokemon;

public class CharmanderFactory implements PokemonFactory {

  private static PokemonDetailsFactory detailsFactory = new CharmanderDetailsFactory();

  @Override
  public Pokemon getPokemon() {
      Pokemon pokemon = new Charmander();
      pokemon.setMove(detailsFactory.getMove());
      pokemon.setType(detailsFactory.getType());
      return pokemon;
  }

}
