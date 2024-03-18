package com.huangsam.payment

class GooglePay(override var balanceAmount: Int) : PayStrategyAbstract() {
    override fun method(): String = "Google LLC"
}
