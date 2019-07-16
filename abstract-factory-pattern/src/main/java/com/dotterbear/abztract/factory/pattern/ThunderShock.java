package com.dotterbear.abztract.factory.pattern;

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
