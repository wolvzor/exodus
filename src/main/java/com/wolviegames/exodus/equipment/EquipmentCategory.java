package com.wolviegames.exodus.equipment;

public enum EquipmentCategory {

    NONE(0),
    SOMETHING(1);

    private final Integer equipmentCategoryValue;

    private EquipmentCategory(Integer equipmentCategoryValue){
        this.equipmentCategoryValue = equipmentCategoryValue;
    }

    public Integer equipmentCategoryValue() {
        return equipmentCategoryValue;
    }
}
