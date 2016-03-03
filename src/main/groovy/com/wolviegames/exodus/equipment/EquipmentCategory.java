package com.wolviegames.exodus.equipment;

public enum EquipmentCategory {

    NONE(0),
    AMMUNITION(1),
    FIREARM(2),
    MELEE(3),
    EXPLOSIVE(4),
    THROWN(5),
    PROJECTILE(6),
    ARMOR(7),
    WEAPON_UPGRADE(8),
    MEDICAL(9),
    CHEMICAL(10),
    CLOTHING(11),
    FIELD_GEAR(12),
    HOUSING(13),
    LODGING(14),
    ENTERTAINMENT(15),
    FOOD(16),
    SERVICES(17),
    MANUAL(18),
    VEHICLE(19);

    private final Integer equipmentCategoryValue;

    private EquipmentCategory(Integer equipmentCategoryValue){
        this.equipmentCategoryValue = equipmentCategoryValue;
    }

    public Integer equipmentCategoryValue() {
        return equipmentCategoryValue;
    }
}
