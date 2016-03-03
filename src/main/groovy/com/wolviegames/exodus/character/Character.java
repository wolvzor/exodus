package com.wolviegames.exodus.character;

public class Character {

    private String characterName;
    private String playerName;
    private int age;
    private Gender gender;
    private Race race;
    private int height; // inches
    private int weight; // pounds


    public Character() {
        this.characterName = "Character Name";
        this.playerName = "Player Name";
        this.age = 0;
        this.gender = Gender.NONE;
        this.race = Race.NONE;
        this.height = 0;
        this.weight = 0;
    }

    public Character(String characterName, String playerName, int age, Gender gender, Race race, int height, int weight) {
        this.characterName = characterName;
        this.playerName = playerName;
        this.age = age;
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weight = weight;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
