# state-pattern
Project of example of state pattern implement by Java.

## What is state pattern
Allows an object to alter its behavior when its internal state changes, The object will appear to change its class.

class diagrams:

![state pattern](https://github.com/kan01234/design-patterns/blob/master/state-pattern/state-pattern.png)

1. State
  - interface that encapsulating the behavior associated with particular state of Context.

2. Concrete State
  - class that implment State and impelement a behavior associated with a state of Context.

3. Context
  - class that maintenance instance of Concrete State subclass that defines the current state.

### Example

Assume we are implement a auto selling machine

possible state of auto selling machine shown as below:
- HAS_COIN
- NO_COIN
- SOLD_OUT

possible ways to use auto selling machin shown as below:
- insert coin
- buy
- refund

class diagram:
![class diagram!](https://github.com/kan01234/design-patterns/blob/master/state-pattern/state-pattern.png)

MachineState interface
```java
public interface MachineState {

  public void insertCoins(AutoSellingMachine autoSellingMachine);

  public void buy(AutoSellingMachine autoSellingMachine);

  public void refund(AutoSellingMachine autoSellingMachine);

}
```

HasCoin, NoCoin, SoldOut are concrete state

HasCoin
```java
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
```

NoCoin
```java
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
```

SoldOut
```java
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
```

testing code for insert coin on different states
```java
AutoSellingMachine machine = new AutoSellingMachine();
// insert when no coins
machine.insertCoins();

// insert when has coin
machine.insertCoins();

// insert when sold out
machine.setMachineState(SOLD_OUT);
machine.insertCoins();
```

output
```
accpet the coin
already has coin, reject the coin
already sold out, reject the coin
```

testing code for buy on different states
```java
AutoSellingMachine machine;
machine = new AutoSellingMachine(1);
// buy without coin
machine.buy();

// buy with coin
machine.insertCoins();
machine.buy();

// buy when sold out
machine.buy();
```

output
```
no coin, can't buy
accpet the coin
sold a product
already sold out, can't buy
```

testing code for refund on different states
```java
AutoSellingMachine machine = new AutoSellingMachine();
// refund when no coin
machine.refund();

// refund when has coin
machine.setMachineState(HAS_COIN);
machine.refund();

// refund when sold out
machine.setMachineState(SOLD_OUT);
machine.refund();
```

output
```
no coin, can't refund
reject the coin
no coin, can't refund
```

Good:

instead of checking the state and then take the action like the code shown as below
```java
public void buy () {
  if (state == hasCoin) {
    // take has coin action
  } else if (state == noCoin) {
    // take no coin action
  } else if (state == soldOut) {
    // take sold out action 
  }
}
```
we put the associated action into the possible state class, it make the code more readable and easy to change.

when one more state to AutoSellingMachine, we only need to add one more conrete state class that implement the MachineState interface, and do not need to make change to original code.
