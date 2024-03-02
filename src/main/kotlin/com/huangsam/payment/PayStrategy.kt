package com.huangsam.payment

interface PayStrategy {
    fun pay(paymentAmount: Int): Boolean

    fun collectPaymentDetails()
}
