package com.wolviegames.exodus.barter

import com.wolviegames.exodus.equipment.Equipment
import groovy.transform.Canonical

import java.security.Timestamp
import java.text.SimpleDateFormat

@Canonical
class Trade {
    TradeStatus status
    Merchant merchant
    String playerCharacter
    Integer bottlecapsOwedToMerchant
    String timeCompleted
    double merchantBarterBias
    private Map<Equipment,Integer> playerEquipmentForSale
    private Map<Equipment,Integer> merchantEquipmentForSale

    Trade(Merchant merchant, String playerCharacter) {
        this.merchant = merchant
        this.playerCharacter = playerCharacter
        this.playerEquipmentForSale = new HashMap<Equipment,Integer>()
        this.merchantEquipmentForSale = new HashMap<Equipment,Integer>()
        status = TradeStatus.OPEN
    }

    void addPlayerEquipmentForSale(Equipment equipment, int quantity){
        playerEquipmentForSale.put(equipment,quantity)
    }

    Map<Equipment, Integer> getPlayerEquipmentForSale(){
        playerEquipmentForSale
    }

    void addMerchantEquipmentForSale(Equipment equipment, int quantity){
        if (merchant.getEquipmentList().contains(equipment)){
            merchantEquipmentForSale.put(equipment,quantity)
        }
    }

    Map<Equipment, Integer> getMerchantEquipmentForSale(){
        merchantEquipmentForSale
    }

    void calculateTrade() {
        int playerBottlecapValue = 0
        int merchantBottlecapValue = 0

        merchantBarterBias = (merchant.getBarterSkillResult(playerCharacter) / 5) * 0.10

        // Player sells for half cost
        for(Map.Entry<Equipment,Integer> entry: playerEquipmentForSale.entrySet()){
            playerBottlecapValue += entry.getKey().getCost() * entry.getValue() / 2 * ( 1 - merchantBarterBias)
        }

        // Merchant
        for(Map.Entry<Equipment,Integer> entry: merchantEquipmentForSale.entrySet()){
            merchantBottlecapValue += entry.getKey().getCost() * entry.getValue() * (1 + merchantBarterBias)
        }

        // assign the bottlecap deficit
        bottlecapsOwedToMerchant = merchantBottlecapValue - playerBottlecapValue
    }

    void completeTrade() {
        Date date = new Date()
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-a");
        this.timeCompleted = sdf.format(date)

        // Create a file to save the transaction
        def fileName = 'trade-' + merchant.getName() +'-' + playerCharacter + '-' + timeCompleted + '.txt'

        String lineSeparator = System.getProperty("line.separator")

        // write the transaction
        new File(fileName).withWriter('utf-8') { writer ->
            writer.write('Player: ' + playerCharacter + lineSeparator)
            writer.write('Merchant: ' + merchant.getName() + lineSeparator)
            writer.write(lineSeparator)
            writer.write("Purchased:" + lineSeparator)
            for(Map.Entry<Equipment,Integer> entry: merchantEquipmentForSale.entrySet()) {
                writer.write(entry.getValue() + " " + entry.getKey().getName()
                        + " for " + (int)(entry.getKey().getCost() * entry.getValue() * (1 + merchantBarterBias)) + " total." + lineSeparator)
            }
            writer.write(lineSeparator)
            writer.write("Sold:" + lineSeparator)
            for(Map.Entry<Equipment,Integer> entry: playerEquipmentForSale.entrySet()) {
                writer.write(entry.getValue() + " " + entry.getKey().getName()
                        + " for " + (int)(entry.getKey().getCost() * entry.getValue() / 2 * ( 1 - merchantBarterBias)) + " total." + lineSeparator)
            }
            writer.write(lineSeparator)
            writer.write("Total bottlecaps owed to merchant: " + bottlecapsOwedToMerchant + lineSeparator)
        }

        status = TradeStatus.CLOSED

    }

}
