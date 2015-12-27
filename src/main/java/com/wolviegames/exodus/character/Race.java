package com.wolviegames.exodus.character;

public enum Race {
    NONE(0),
    HUMAN(1),
    GHUL(2),
    TRANS_GENETIC_MUTANT(3);

    private final int value;

    Race(final int newValue){
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
