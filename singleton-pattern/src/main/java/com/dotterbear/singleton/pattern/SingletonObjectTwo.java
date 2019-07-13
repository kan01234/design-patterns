package com.dotterbear.singleton.pattern;

public class SingletonObjectTwo {

  private static SingletonObjectTwo instance  = null;

  private SingletonObjectTwo() {
  }

  public static SingletonObjectTwo getInstance() {
    if (instance == null) {
      synchronized(SingletonObjectTwo.class) {
        if(instance == null) {
          instance = new SingletonObjectTwo();
        }    
      }
    }
    return instance;
  }

}