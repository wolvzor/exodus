package com.wolviegames.exodus.equipment;

public enum Scarcity {

    COMMON(0),
    UNCOMMON(1),
    INFREQUENT(2),
    RARE(3),
    VERY_RARE(4),
    UNIQUE(5);

    private final Integer scarcityValue;

    private Scarcity(Integer scarcityValue) {
        this.scarcityValue = scarcityValue;
    }

    public Integer scarcityValue() {
        return scarcityValue;
    }

}
