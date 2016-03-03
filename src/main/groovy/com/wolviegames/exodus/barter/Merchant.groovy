package com.wolviegames.exodus.barter

import com.wolviegames.exodus.equipment.EquipmentCategory
import groovy.transform.Canonical

@Canonical
class Merchant {
    String name
    String location
    int barterSkill
    List<EquipmentCategory> equipmentCategories
}
