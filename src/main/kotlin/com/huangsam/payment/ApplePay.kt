package com.huangsam.payment

class ApplePay(override var balanceAmount: Int) : PayStrategy() {
    override fun company(): String = "Apple Incorporated"
}
