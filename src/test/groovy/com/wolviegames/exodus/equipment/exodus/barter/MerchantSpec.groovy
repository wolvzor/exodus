package com.wolviegames.exodus.equipment.exodus.barter

import com.wolviegames.exodus.barter.Merchant
import com.wolviegames.exodus.equipment.EquipmentCategory
import spock.lang.Specification


class MerchantSpec extends Specification {

    def setup(){

    }

    def "Merchants have a name, location, barter skill, and a list of possible equipment types"() {
        setup:
        List<EquipmentCategory> equipmentCategories =
                Arrays.asList(EquipmentCategory.AMMUNITION,EquipmentCategory.ARMOR)

        when:
        Merchant merchant = new Merchant("name","location",10,equipmentCategories)

        then:
        merchant.getName() == "name"
        merchant.getLocation() == "location"
        merchant.getBarterSkill() == 10
        merchant.getEquipmentCategories() == equipmentCategories
    }

    def "Merchants have a barter result stored by the character who performed it"() {
        setup:
        Merchant merchant = new Merchant()
        merchant.setBarterSkill(30)

        when: "A PC rolls a barter skill w/ a result of 30"
        merchant.performBarterRoll("PC name", 30)

        then: "The merchant now has barter result, which will be positive in this case"
        merchant.getBarterSkillResult("PC name") > 0
    }

}