package com.huangsam.payment

class GooglePay(override var balanceAmount: Int) : PayStrategy() {
    override fun method(): String = "Google LLC"
}
