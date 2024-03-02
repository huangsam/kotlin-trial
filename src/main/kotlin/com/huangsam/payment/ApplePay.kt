package com.huangsam.payment

class ApplePay(override var balanceAmount: Int) : PaymentMethod() {
    override fun method(): String = "Apple Incorporated"
}
