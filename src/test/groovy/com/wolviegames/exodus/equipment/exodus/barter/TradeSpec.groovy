package com.wolviegames.exodus.equipment.exodus.barter

import com.wolviegames.exodus.barter.Merchant
import com.wolviegames.exodus.barter.Trade
import com.wolviegames.exodus.barter.TradeStatus
import spock.lang.Specification


class TradeSpec extends Specification {

    def setup() {

    }

    def "A trade can be open or closed, with open being the default"() {
        setup:
        Trade openTrade

        when:
        openTrade = new Trade()

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
        openTrade = new Trade(merchant)

        then:
        openTrade.getStatus() == TradeStatus.OPEN
        openTrade.getMerchant() == merchant
    }

}