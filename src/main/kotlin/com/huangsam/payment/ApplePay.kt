package com.huangsam.payment

class ApplePay(override var balanceAmount: Int) : PayStrategy() {
    override fun method(): String = "Apple Incorporated"
}
