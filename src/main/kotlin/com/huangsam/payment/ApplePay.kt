package com.huangsam.payment

class ApplePay(balance: Int) : PayStrategy(balance) {
    override val company: String = "Apple Incorporated"
}
