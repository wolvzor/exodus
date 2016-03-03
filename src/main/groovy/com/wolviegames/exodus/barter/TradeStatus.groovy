package com.wolviegames.exodus.barter;

public enum TradeStatus {
    OPEN(0),
    CLOSED(1);

    private final int value;

    TradeStatus(final int newValue){
        value = newValue;
    }

    public int getValue() {
        return value;
    }

}
