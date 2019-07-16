package com.dotterbear.abztract.factory.pattern;

public class BulbasaurDetailsFactory implements PokemonDetailsFactory {

  @Override
  public Type getType() {
    return new Grass();
  }

  @Override
  public Move getMove(){
    return new Growl();
  }

}
