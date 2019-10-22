# mediator-pattern
Project of eample of mediator pattern implement by Java.

## What is mediator pattern
- define object that encapsulates set of interaction bewteen other objects.
- loose coupling by keeping objects from referring to each other
- allow to change their interaction independently

class diagram:

![mediator pattern](https://github.com/kan01234/design-patterns/blob/master/mediator-pattern/mediator-pattern.png)

1. Mediator
    - interface define interact between Colleague objects

2. ConcreteMediator
    - class that implment Mediator, implmentation to define interaction between Colleagues

3. Colleague
    - interface define communucation with other Colleagues by Mediator

4. ConcreteColleague
    - class that implement Colleague

dependencies bewteen Colleagues without Mediator:

![without-mediator](https://github.com/kan01234/design-patterns/blob/master/mediator-pattern/without-mediator.png)

dependencies bewteen Colleagues with Mediator:

![with-mediator](https://github.com/kan01234/design-patterns/blob/master/mediator-pattern/with-mediator.png)

## Example
Assume we are building a auto selling machine, and there are having below components and action

1. buy button
    - press for buy action
    - buy ok if have coin
    - buy not ok if no coin

2. refund button
    - press for refund action
    - refund ok if have coin
    - refund not ok if no coin

3. coin slot
    - insert coin
    - unable to insert coin if have coin already

for above you can see, the press button and refund button need to know there are has coin or not.

class diagram:

![mediator pattern](https://github.com/kan01234/design-patterns/blob/master/mediator-pattern/mediator-pattern-example.png)

1. ComponentMediator is Mediator
2. AutoSellingMachineMediator is ConcreteMediator
3. Component is Colleague
4. BuyButton, RefundButton and CoinSlot are Concrete Colleague

Component will have ComponentMediator
```java
public abstract class Component {

    protected ComponentMediator componentMediator;

    // getter, setter
}
```

abstract class Button extends Component
```java
public abstract class Button extends Component {
    public abstract void press();
}
```

BuyButton, implement function when BuyButton has been pressed
```java
public class BuyButton extends Button  {

    @Override
    public void press() {
        componentMediator.buy();
    }

}
```

RefundButton, implement function when RefundButton has been pressed
```java
public class RefundButton extends Button {

    @Override
    public void press() {
        componentMediator.refund();
    }

}
```

CoinSlot, for insert coin and hold coin state
```java
public class CoinSlot extends Component {

    private boolean hasCoin = false;

    public void insertCoin() {
        hasCoin = true;
    }

    public boolean isHasCoin() {
        return hasCoin;
    }

    public void setHasCoin(boolean hasCoin) {
        this.hasCoin = hasCoin;
    }

}
```

ComponentMediator define the action needed
```java
public interface ComponentMediator {

    public void buy();

    public void refund();

    public void insertCoin();

}
```

AutoSellingMachineMediator is concrete mediator
```java
public class AutoSellingMachineMediator implements ComponentMediator {

    private CoinSlot coinSlot;

    public void setCoinSlot(CoinSlot coinSlot) {
        this.coinSlot = coinSlot;
    }

    @Override
    public void buy() {
        if (coinSlot.isHasCoin()) {
            System.out.println("buy is ok, thanks you.");
            coinSlot.setHasCoin(false);
        } else {
            System.out.println("no coin, please insert coin before buy");
        }
    }

    // other function

}
```

that makes BuyButton or RefundButton do not need to know the internal state of CoinSlot, and perform buy or refund action by ComponentMediator

example of buying
```java
@Test
public void test() {
    AutoSellingMachineMediator mediator = new AutoSellingMachineMediator();
    Button buyButton = new BuyButton();
    Button refundButton = new RefundButton();
    CoinSlot coinSlot = new CoinSlot();
    mediator.setCoinSlot(coinSlot);
    buyButton.setComponentMediator(mediator);
    refundButton.setComponentMediator(mediator);
    coinSlot.setComponentMediator(mediator);
    System.out.println("insert coin and buy");
    coinSlot.insertCoin();
    buyButton.press();
}
```

output
```
insert coin and buy
buy is ok, thanks you.
```