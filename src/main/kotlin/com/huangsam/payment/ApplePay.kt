package com.huangsam.payment

class ApplePay(override var balanceAmount: Int) : PayStrategyAbstract() {
    override fun method(): String = "Apple Incorporated"
}
