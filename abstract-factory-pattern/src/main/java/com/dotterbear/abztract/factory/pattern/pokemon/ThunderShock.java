package com.dotterbear.abztract.factory.pattern.pokemon;

public class ThunderShock implements Move {

  @Override
  public int getPower() {
    return 40;
  }

  @Override
  public String getName() {
    return "Thunder Shock";
  }

}
