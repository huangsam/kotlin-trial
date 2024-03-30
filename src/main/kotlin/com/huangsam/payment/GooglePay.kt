package com.huangsam.payment

class GooglePay(balance: Int) : PayStrategy(balance) {
    override val company: String = "Google LLC"
}
