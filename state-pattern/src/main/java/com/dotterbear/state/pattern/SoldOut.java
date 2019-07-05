package com.dotterbear.state.pattern;

public class SoldOut implements MachineState {

  public void insertCoins(AutoSellingMachine autoSellingMachine) {
    System.out.println("already sold out, reject the coin");
    return;
  }

  public void buy(AutoSellingMachine autoSellingMachine) {
    System.out.println("already sold out, can't buy");
    return;
  }

  public void refund(AutoSellingMachine autoSellingMachine) {
    System.out.println("no coin, can't refund");
    return;
  }

}
