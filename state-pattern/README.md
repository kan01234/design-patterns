# state-pattern
Project of eample of state pattern implement by Java.

## What is state pattern
Allows an object to alter its behavior when its internal state changes, The object will appear to change its class.
it will has 3 main role in state pattern.

1. Context

Maintenance instance of Concrete State subclass that defines the current state.

2. State

Defines an interface for encapsulating the behavior associated with particular state of Context.

3. Concrete State

Subclasses impelement a behavior associated with a state of Context.

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

role explain:
- AutoSellingMachine is Context
- MachineState is State
- HasCoin, NoCoin, SoldOut are Concrete State

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
