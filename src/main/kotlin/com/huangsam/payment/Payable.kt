package com.huangsam.payment

interface Payable {
    fun pay(paymentAmount: Int): Boolean

    fun collectPaymentDetails()
}
