package com.dotterbear.abztract.factory.pattern.pokemon;

public class CharmanderDetailsFactory implements PokemonDetailsFactory{

  @Override
  public Type getType() {
    return new Fire();
  }

  @Override
  public Move getMove(){
    return new Scratch();
  }

}
