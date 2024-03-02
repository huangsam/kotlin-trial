package com.huangsam.payment

class GooglePay(override var balanceAmount: Int) : PaymentMethod() {
    override fun method(): String = "Google LLC"
}
