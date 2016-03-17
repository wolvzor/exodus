package com.wolviegames.exodus.equipment.exodus.character

import com.wolviegames.exodus.character.Character
import com.wolviegames.exodus.character.Gender
import com.wolviegames.exodus.character.Race
import spock.lang.Specification;

public class CharacterSpec extends Specification {

    def setup() {

    }

    def "Character has default character name, player name, age, gender, race, height and weight"() {
        when:
        Character character = new Character()

        then:
        character.getCharacterName().equals("Character Name")
        character.getPlayerName().equals("Player Name")
        character.getAge().equals(0)
        character.getGender().equals(Gender.NONE)
        character.getRace().equals(Race.NONE)
        character.getHeight().equals(0)
        character.getWeight().equals(0)
    }

    def "Character can also be created with known values"() {
        when:
        Character character = new Character(characterName:"Test Character",playerName:"Wolvie",age:25,
                gender:Gender.FEMALE,race:Race.HUMAN,height:60,weight:120)

        then:
        character.getCharacterName().equals("Test Character")
        character.getPlayerName().equals("Wolvie")
        character.getAge().equals(25)
        character.getGender().equals(Gender.FEMALE)
        character.getRace().equals(Race.HUMAN)
        character.getHeight().equals(60)
        character.getWeight().equals(120)
    }

    def "Gender is an enumeration"() {
        setup:
        Character character = new Character()

        when:
        character.setGender(Gender.GENDERQUEER)

        then:
        character.getGender().equals(Gender.GENDERQUEER)
    }

    def "Race is an enumeration"() {
        setup:
        Character character = new Character()

        when:
        character.setRace(Race.GHUL)

        then:
        character.getRace().equals(Race.GHUL)
    }

}
