package com.wolviegames.exodus.equipment

import com.wolviegames.exodus.equipment.Equipment
import com.wolviegames.exodus.equipment.EquipmentCategory
import com.wolviegames.exodus.equipment.Scarcity

class EquipmentLoader {

    private List<String> xmlFileNames

    private List<Equipment> equipmentList

    EquipmentLoader(String xmlFileName) {

        // Load the list of equipment xml files
        ClassLoader classLoader = getClass().getClassLoader()
        xmlFileNames = new ArrayList<String>()

        def rootNode = new XmlSlurper().parseText(new File(classLoader.getResource(xmlFileName).getFile()).getText())

        rootNode.fileList.file.each {
            System.out.println(it.text())
            xmlFileNames.add(it.text())
        }

        equipmentList = new ArrayList<Equipment>()

    }

    public load() {
        ClassLoader classLoader = getClass().getClassLoader()

        for (String xmlFileName : xmlFileNames) {
            System.out.println(xmlFileName)
            def rootNode = new XmlSlurper().parseText(new File(classLoader.getResource(xmlFileName).getFile()).getText())

            rootNode.equipments.children().each {
                equipmentList.add(new Equipment(it.name.text(), it.description.text(), it.weight.text().toDouble(),
                        it.cost.text().toInteger(), EquipmentCategory.valueOf(it.category.text()), Scarcity.valueOf(it.scarcity.text())))

        }
    }

    }

    List<Equipment> getEquipment() {
        return equipmentList
    }
}
