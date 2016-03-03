package com.wolviegames.exodus.barter

import com.wolviegames.exodus.equipment.EquipmentCategory
import groovy.transform.Canonical

@Canonical
class Merchant {
    String name
    String location
    int barterSkill
    List<EquipmentCategory> equipmentCategories
    Map<String, Integer> barterResults = new HashMap<String, Integer>()

    // Performs a barter roll result
    // Positive represents merchant win
    // TODO translate this to a %discount
    void performBarterRoll(String pcName, int pcBarterResult){
        // TODO create a dice roller
        int barterRollResult = (int)(Math.random() * 20) + 1 + barterSkill
        barterResults.put(pcName,barterRollResult - pcBarterResult)
    }

    int getBarterSkillResult(String pcName){
        return barterResults.get(pcName)
    }
}
