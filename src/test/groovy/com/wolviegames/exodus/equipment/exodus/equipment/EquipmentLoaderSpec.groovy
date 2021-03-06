package com.wolviegames.exodus.equipment.exodus.equipment

import com.wolviegames.exodus.equipment.EquipmentCategory
import com.wolviegames.exodus.equipment.EquipmentLoader
import com.wolviegames.exodus.equipment.Scarcity;
import spock.lang.Specification;

public class EquipmentLoaderSpec extends Specification {

    def setup() {

    }

    def "Equipment loader reads equipment from an XML file"() {
        setup:
        def xmlFileName = "testEquipmentList.xml"

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

    def "Equipment loader loads the ammunition equipment"() {
        setup:
        def xmlFileName =  "config/EquipmentFileList.xml"
        EquipmentLoader equipmentLoader = new EquipmentLoader(xmlFileName)

        when:
        equipmentLoader.load()

        then:
        equipmentLoader.getEquipment().size() == 32;
    }

    def "Equipment loader can load multiple files"() {
        setup:
        def xmlFileName = "testEquipmentMultipleList.xml"
        EquipmentLoader equipmentLoader = new EquipmentLoader(xmlFileName)

        when:
        equipmentLoader.load()

        then:
        equipmentLoader.getEquipment().size() == 34;
    }

    // TODO Exceptions
}
