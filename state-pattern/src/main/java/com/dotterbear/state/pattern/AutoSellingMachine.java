package com.dotterbear.state.pattern;

public class AutoSellingMachine {

  public static final MachineState HAS_COIN = new HasCoin();

  public static final MachineState NO_COIN = new NoCoin();

  public static final MachineState SOLD_OUT = new SoldOut();

  private MachineState machineState = NO_COIN;

  private int numOfProduct = 10;

  public AutoSellingMachine() {
    super();
  }

  public AutoSellingMachine(int numOfProduct) {
    super();
    this.numOfProduct = numOfProduct;
    if (numOfProduct <= 0)
      machineState = SOLD_OUT;
  }

  public MachineState getMachineState() {
    return machineState;
  }

  public void setMachineState(MachineState machineState) {
    this.machineState = machineState;
  }

  public int getNumOfProduct() {
    return numOfProduct;
  }

  public void setNumOfProduct(int numOfProduct) {
    this.numOfProduct = numOfProduct;
  }

  public void insertCoins() {
    machineState.insertCoins(this);
  }

  public void buy() {
    machineState.buy(this);
  }

  public void refund() {
    machineState.refund(this);
  }

  @Override
  public String toString() {
    return "AutoSellingMachine [machineState=" + machineState + ", numOfProduct=" + numOfProduct
        + "]";
  }

}
