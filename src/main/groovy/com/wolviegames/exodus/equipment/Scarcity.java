package com.wolviegames.exodus.equipment;

public enum Scarcity {

    COMMON(1.0),
    UNCOMMON(0.5),
    INFREQUENT(0.25),
    RARE(0.1),
    VERY_RARE(0.05),
    UNIQUE(0.0);

    private final Double scarcityValue;

    private Scarcity(Double scarcityValue) {
        this.scarcityValue = scarcityValue;
    }

    public Double scarcityValue() {
        return scarcityValue;
    }

    public boolean scarcityRoll() {
        return Math.random() < scarcityValue;
    }

}
