package com.wolviegames.exodus.character

import groovy.transform.Canonical;

@Canonical
public class Character {

    String characterName;
    String playerName;
    Integer age;
    Gender gender;
    Race race;
    Integer height; // inches
    Integer weight; // pounds

    public Character() {
        this.characterName = "Character Name";
        this.playerName = "Player Name";
        this.age = 0;
        this.gender = Gender.NONE;
        this.race = Race.NONE;
        this.height = 0;
        this.weight = 0;
    }

}
