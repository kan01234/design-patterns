package com.dotterbear.mediator.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dotterbear.mediator.pattern.AutoSellingMachineMediator;
import com.dotterbear.mediator.pattern.CoinSlot;

import org.junit.jupiter.api.Test;

public class MediatorPatternTest {

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
        System.out.println("press button without insert coin");
        buyButton.press();
        refundButton.press();
        System.out.println("insert coin and buy");
        coinSlot.insertCoin();
        buyButton.press();
        System.out.println("insert coin and refund");
        coinSlot.insertCoin();
        refundButton.press();
    }

}