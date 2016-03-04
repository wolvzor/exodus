package com.wolviegames.exodus.equipment.exodus.barter

import com.wolviegames.exodus.barter.Merchant
import com.wolviegames.exodus.barter.Trade
import com.wolviegames.exodus.barter.TradeStatus
import com.wolviegames.exodus.equipment.Equipment
import com.wolviegames.exodus.equipment.EquipmentCategory
import com.wolviegames.exodus.equipment.Scarcity
import spock.lang.Shared
import spock.lang.Specification


class TradeSpec extends Specification {

    @Shared
    Equipment ammo

    @Shared
    Equipment armor

    @Shared
    String player

    def setupSpec() {
        player = "Player"
        ammo = new Equipment("ammo","ammo_desc",1.0,4,EquipmentCategory.AMMUNITION,Scarcity.UNIQUE)
        armor = new Equipment("armor","armor_desc",4,50,EquipmentCategory.ARMOR,Scarcity.COMMON)
    }

    def "A trade can be open or closed, with open being the default"() {
        setup:
        Trade openTrade

        when:
        openTrade = new Trade(new Merchant(), player)

        then:
        openTrade.getStatus() == TradeStatus.OPEN

        when:
        openTrade.setStatus(TradeStatus.CLOSED)

        then:
        openTrade.getStatus() == TradeStatus.CLOSED
    }

    def "A trade also has a merchant, which cannot be defaulted"() {
        setup:
        Trade openTrade
        Merchant merchant = new Merchant()

        when:
        openTrade = new Trade(merchant, player)

        then:
        openTrade.getStatus() == TradeStatus.OPEN
        openTrade.getMerchant() == merchant
    }

    def "A trade has a map of things that the player is selling, and how much"() {
        setup:
        Merchant merchant = new Merchant()
        Trade openTrade = new Trade(merchant, player)
        int quantity = 4

        when:
        openTrade.addPlayerEquipmentForSale(ammo,quantity)

        then:
        openTrade.getPlayerEquipmentForSale().get(ammo) == quantity
    }

    def "A trade has a map of things that the player is buying, and how much"() {
        setup:
        Merchant merchant = new Merchant()
        merchant.setEquipmentCategories(Arrays.asList(EquipmentCategory.ARMOR))
        merchant.setEquipmentList(Arrays.asList(armor))
        Trade openTrade = new Trade(merchant, player)
        int quantity = 7

        when:
        openTrade.addMerchantEquipmentForSale(armor,quantity)

        then:
        openTrade.getMerchantEquipmentForSale().get(armor) == quantity
    }

    def "Comparing a trade will show the items being traded, as well as the bottlecap difference"() {
        setup:
        Merchant merchant = new Merchant()
        String player = "Player"
        merchant.setEquipmentCategories(Arrays.asList(EquipmentCategory.ARMOR))
        merchant.setEquipmentList(Arrays.asList(armor))
        merchant.getBarterResults().put(player, 0)
        Trade openTrade = new Trade(merchant,player)

        int ammoQuantity = 10
        int armorQuantity = 2

        when:
        openTrade.addMerchantEquipmentForSale(armor, armorQuantity)
        openTrade.addPlayerEquipmentForSale(ammo, ammoQuantity)
        openTrade.calculateTrade()

        then: "the difference is 20 vs 100, since player sells for half cost"
        openTrade.getBottlecapsOwedToMerchant() == 80
    }

    def "Comparing a trade will show the items being traded if merchant has advantage"() {
        setup:
        Merchant merchant = new Merchant()
        String player = "Player"
        merchant.setEquipmentCategories(Arrays.asList(EquipmentCategory.ARMOR))
        merchant.setEquipmentList(Arrays.asList(armor))
        merchant.getBarterResults().put(player, 5)
        Trade openTrade = new Trade(merchant,player)

        int ammoQuantity = 10
        int armorQuantity = 2

        when:
        openTrade.addMerchantEquipmentForSale(armor, armorQuantity)
        openTrade.addPlayerEquipmentForSale(ammo, ammoQuantity)
        openTrade.calculateTrade()

        then: "the difference is 18 vs 110, since player sells for half cost and the merchant gets the 10%"
        openTrade.getBottlecapsOwedToMerchant() == 92
    }

    def "Comparing a trade will show the items being traded if player has advantage"() {
        setup:
        Merchant merchant = new Merchant()
        String player = "Player"
        merchant.setEquipmentCategories(Arrays.asList(EquipmentCategory.ARMOR))
        merchant.setEquipmentList(Arrays.asList(armor))
        merchant.getBarterResults().put(player, -5)
        Trade openTrade = new Trade(merchant,player)

        int ammoQuantity = 10
        int armorQuantity = 2

        when:
        openTrade.addMerchantEquipmentForSale(armor, armorQuantity)
        openTrade.addPlayerEquipmentForSale(ammo, ammoQuantity)
        openTrade.calculateTrade()

        then: "the difference is 22 vs 90, since player sells for half cost and the merchant gets the 10%"
        openTrade.getBottlecapsOwedToMerchant() == 68
    }

    def "Accepting a trade will close the trade and create a file w/ the results for record keeping"() {
        setup:
        Merchant merchant = new Merchant()
        merchant.setName("testMerchant")
        String player = "Player"
        merchant.setEquipmentCategories(Arrays.asList(EquipmentCategory.ARMOR))
        merchant.setEquipmentList(Arrays.asList(armor))
        merchant.getBarterResults().put(player, -5)
        Trade openTrade = new Trade(merchant,player)

        int ammoQuantity = 10
        int armorQuantity = 2

        openTrade.addMerchantEquipmentForSale(armor, armorQuantity)
        openTrade.addPlayerEquipmentForSale(ammo, ammoQuantity)
        openTrade.calculateTrade()

        String lineSeparator = System.getProperty("line.separator")

        when:
        openTrade.completeTrade()
        def fileName = 'trade-' + merchant.getName() +'-' + player + '-' + openTrade.getTimeCompleted() + '.txt'

        then:
        openTrade.status == TradeStatus.CLOSED
        String fileContents = new File(fileName).text
        fileContents == "Player: " + player + lineSeparator +
                        "Merchant: " + merchant.getName() + lineSeparator +
                        "Barter Bias: " + merchant.getBarterSkillResult(player) + lineSeparator +
                        lineSeparator +
                        "Purchased:" + lineSeparator +
                        armorQuantity + " " + armor.getName() + " for 90 total." + lineSeparator +
                        lineSeparator +
                        "Sold:" + lineSeparator +
                        ammoQuantity + " " + ammo.getName() + " for 22 total." + lineSeparator +
                        lineSeparator +
                        "Total bottlecaps owed to merchant: " + openTrade.getBottlecapsOwedToMerchant() + lineSeparator
    }

}