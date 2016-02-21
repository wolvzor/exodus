package com.wolviegames.exodus.equipment


class EquipmentLoader {

    private String xmlFileName = "testEquipmentFile.xml"

    private List<Equipment> equipmentList

    EquipmentLoader() {
        equipmentList = new ArrayList<Equipment>()
    }

    public load() {
        equipmentList = new ArrayList<Equipment>()

        ClassLoader classLoader = getClass().getClassLoader()
        def rootNode = new XmlSlurper().parseText( new File(classLoader.getResource(xmlFileName).getFile()).getText())

        rootNode.equipments.children().each{
            equipmentList.add(new Equipment(it.name.text(),it.description.text(),it.weight.text().toDouble(),it.cost.text().toInteger(),EquipmentCategory.valueOf(it.category.text()),Scarcity.valueOf(it.scarcity.text())))
        }

    }

    List<Equipment> getEquipment() {
        return equipmentList
    }
}
