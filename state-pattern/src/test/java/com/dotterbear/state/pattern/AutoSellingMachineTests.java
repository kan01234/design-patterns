package com.dotterbear.state.pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static com.dotterbear.state.pattern.AutoSellingMachine.HAS_COIN;
import static com.dotterbear.state.pattern.AutoSellingMachine.NO_COIN;
import static com.dotterbear.state.pattern.AutoSellingMachine.SOLD_OUT;


public class AutoSellingMachineTests {

  @Test
  public void testInit() {
    AutoSellingMachine machine;
    machine = new AutoSellingMachine();
    assertEquals(machine.getMachineState(), NO_COIN);
    machine = new AutoSellingMachine(1);
    assertEquals(machine.getMachineState(), NO_COIN);
    machine = new AutoSellingMachine(0);
    assertEquals(machine.getMachineState(), SOLD_OUT);
  }

  @Test
  public void testInsertCoin() {
    AutoSellingMachine machine;
    machine = new AutoSellingMachine();
    machine.insertCoins();
    assertEquals(machine.getMachineState(), HAS_COIN);
    machine.insertCoins();
    assertEquals(machine.getMachineState(), HAS_COIN);
    machine.setMachineState(SOLD_OUT);
    machine.insertCoins();
    assertEquals(machine.getMachineState(), SOLD_OUT);
  }

  @Test
  public void testBuy() {
    AutoSellingMachine machine;
    machine = new AutoSellingMachine(2);
    int numOfProduct = machine.getNumOfProduct();
    machine.buy();
    assertAll("buy with no coin",
        () -> assertEquals(machine.getMachineState(), NO_COIN),
        () -> assertEquals(machine.getNumOfProduct(), numOfProduct)
    );
    machine.insertCoins();
    machine.buy();
    assertAll("buy with coin, to no coin",
        () -> assertEquals(machine.getMachineState(), NO_COIN),
        () -> assertEquals(machine.getNumOfProduct(), numOfProduct - 1)
    );
    machine.insertCoins();
    machine.buy();
    assertAll("buy with coin, to sold out",
        () -> assertEquals(machine.getMachineState(), SOLD_OUT),
        () -> assertEquals(machine.getNumOfProduct(), numOfProduct - 2)
    );
  }

  @Test
  public void testRefund() {
    AutoSellingMachine machine;
    machine = new AutoSellingMachine();
    machine.refund();
    assertEquals(machine.getMachineState(), NO_COIN);
    machine.setMachineState(HAS_COIN);
    machine.refund();
    assertEquals(machine.getMachineState(), NO_COIN);
    machine.setMachineState(SOLD_OUT);
    machine.refund();
    assertEquals(machine.getMachineState(), SOLD_OUT);
  }
}
