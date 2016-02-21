package com.wolviegames.exodus.equipment


class EquipmentLoader {

    private String xmlFileName

    private List<Equipment> equipmentList

    EquipmentLoader(String xmlFileName) {
        this.xmlFileName = xmlFileName
        equipmentList = new ArrayList<Equipment>()
    }

    public load() {
        ClassLoader classLoader = getClass().getClassLoader()
        def rootNode = new XmlSlurper().parseText( new File(classLoader.getResource(xmlFileName).getFile()).getText())

        rootNode.equipments.children().each{
            equipmentList.add(new Equipment(it.name.text(),it.description.text(),it.weight.text().toDouble(),
                    it.cost.text().toInteger(),EquipmentCategory.valueOf(it.category.text()),Scarcity.valueOf(it.scarcity.text())))
        }

    }

    List<Equipment> getEquipment() {
        return equipmentList
    }
}
