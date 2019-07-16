package com.dotterbear.abztract.factory.pattern;

public abstract class Pokemon {

  protected Move move;

  protected Type type;

  abstract String getName();

  public Move getMove() {
    return move;
  }

  public Pokemon setMove(Move move) {
    this.move = move;
    return this;
  }

  public Type getType() {
    return type;
  }

  public Pokemon setType(Type type) {
    this.type = type;
    return this;
  }

}
