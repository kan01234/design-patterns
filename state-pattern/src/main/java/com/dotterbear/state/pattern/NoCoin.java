package com.dotterbear.state.pattern;

public class NoCoin implements MachineState {

  public void insertCoins(AutoSellingMachine autoSellingMachine) {
    System.out.println("accpet the coin");
    autoSellingMachine.setMachineState(AutoSellingMachine.HAS_COIN);
  }

  public void buy(AutoSellingMachine autoSellingMachine) {
    System.out.println("no coin, can't buy");
    return;
  }

  public void refund(AutoSellingMachine autoSellingMachine) {
    System.out.println("no coin, can't refund");
    return;
  }

}
