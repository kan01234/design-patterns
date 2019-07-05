package com.dotterbear.state.pattern;

public class HasCoin implements MachineState {

  public void insertCoins(AutoSellingMachine autoSellingMachine) {
    System.out.println("already has coin, reject the coin");
    return;
  }

  public void buy(AutoSellingMachine autoSellingMachine) {
    System.out.println("sold a product");
    int numOfProduct = autoSellingMachine.getNumOfProduct() - 1;
    autoSellingMachine.setNumOfProduct(numOfProduct);
    autoSellingMachine.setMachineState(
        numOfProduct == 0 ? AutoSellingMachine.SOLD_OUT : AutoSellingMachine.NO_COIN);
  }

  public void refund(AutoSellingMachine autoSellingMachine) {
    System.out.println("reject the coin");
    autoSellingMachine.setMachineState(AutoSellingMachine.NO_COIN);
  }

}
