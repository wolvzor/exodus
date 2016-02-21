package com.wolviegames.exodus.equipment

import spock.lang.Specification

class EquipmentSpec extends Specification {

    def setup() {

    }

    def "Equipment has a name, description, cost, and weight"() {
        when:
        Equipment equipment = new Equipment()

        then:
        equipment.getName() == "Name"
        equipment.getDescription() == "Description"
        equipment.getWeight() == 0
        equipment.getCost() == 0
    }

    def "Equipment has a category enumeration"() {
        when:
        Equipment equipment = new Equipment()

        then:
        equipment.getEquipmentCategory() == EquipmentCategory.NONE
    }

    def "Equipment also has a scarcity"() {
        when:
        Equipment equipment = new Equipment()

        then:
        equipment.getScarcity() == Scarcity.COMMON
    }
}
