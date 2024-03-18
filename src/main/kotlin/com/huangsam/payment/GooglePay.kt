package com.huangsam.payment

class GooglePay(override var balanceAmount: Int) : PayStrategy() {
    override fun company(): String = "Google LLC"
}
