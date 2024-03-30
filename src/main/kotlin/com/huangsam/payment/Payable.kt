package com.huangsam.payment

interface Payable {
    fun makePayment(paymentAmount: Int): Boolean

    fun displayProvider()
}
