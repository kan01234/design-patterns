package com.dotterbear.abztract.factory.pattern;

public class SquirtleDetailsFactory implements PokemonDetailsFactory{

  @Override
  public Type getType() {
    return new Water();
  }

  @Override
  public Move getMove(){
    return new TailWhip();
  }

}
