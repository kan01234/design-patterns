package com.dotterbear.mediator.pattern;

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