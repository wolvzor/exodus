package com.wolviegames.exodus.barter

import groovy.transform.Canonical

@Canonical
class Trade {
    TradeStatus status
    Merchant merchant

    Trade(Merchant merchant) {
        this.merchant = merchant
        status = TradeStatus.OPEN
    }
}
