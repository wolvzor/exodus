package com.wolviegames.exodus.equipment;

import spock.lang.Specification;

public class EquipmentLoaderSpec extends Specification {

    def setup() {

    }

    def "Equipment loader reads equipment from an XML file"() {
        setup:
        def xmlFileName = "testEquipmentFile.xml"
        EquipmentLoader equipmentLoader = new EquipmentLoader(xmlFileName)

        when:
        equipmentLoader.load();

        then:
        equipmentLoader.getEquipment().size() == 2;
        equipmentLoader.getEquipment().get(0).getName() == "Equipment Name"
        equipmentLoader.getEquipment().get(0).getDescription() == "Equipment Description"
        equipmentLoader.getEquipment().get(0).getWeight() == 1.25
        equipmentLoader.getEquipment().get(0).getCost() == 100
        equipmentLoader.getEquipment().get(0).getScarcity() == Scarcity.INFREQUENT
        equipmentLoader.getEquipment().get(0).getEquipmentCategory() == EquipmentCategory.ARMOR

        equipmentLoader.getEquipment().get(1).getName() == "Equipment Name 2"
        equipmentLoader.getEquipment().get(1).getDescription() == "Equipment Description 2"
        equipmentLoader.getEquipment().get(1).getWeight() == 3
        equipmentLoader.getEquipment().get(1).getCost() == 75
        equipmentLoader.getEquipment().get(1).getScarcity() == Scarcity.RARE
        equipmentLoader.getEquipment().get(1).getEquipmentCategory() == EquipmentCategory.MANUAL
    }

    // TODO Exceptions
}
