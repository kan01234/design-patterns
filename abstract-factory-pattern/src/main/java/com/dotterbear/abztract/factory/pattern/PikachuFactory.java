package com.dotterbear.abztract.factory.pattern;

public class PikachuFactory implements PokemonFactory {

  private static PokemonDetailsFactory detailsFactory = new PikachuDetailsFactory();

  @Override
  public Pokemon getPokemon() {
      Pokemon pokemon = new Pikachu();
      pokemon.setMove(detailsFactory.getMove());
      pokemon.setType(detailsFactory.getType());
      return pokemon;
  }

}
