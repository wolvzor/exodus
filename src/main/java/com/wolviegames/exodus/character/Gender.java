package com.wolviegames.exodus.character;

public enum Gender {
    NONE(0),
    MALE(1),
    FEMALE(2),
    GENDERQUEER(3);

    private final int value;

    Gender(final int newValue){
        value = newValue;
    }

    public int getValue() {
        return value;
    }

}
