package com.dotterbear.abztract.factory.pattern;

public class PikachuDetailsFactory implements PokemonDetailsFactory {

  @Override
  public Type getType() {
    return new Electric();
  }

  @Override
  public Move getMove(){
    return new ThunderShock();
  }

}
