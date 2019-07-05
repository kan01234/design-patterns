package com.dotterbear.state.pattern;

public interface MachineState {

  public void insertCoins(AutoSellingMachine autoSellingMachine);

  public void buy(AutoSellingMachine autoSellingMachine);

  public void refund(AutoSellingMachine autoSellingMachine);

}
