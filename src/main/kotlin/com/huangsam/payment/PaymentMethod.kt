package com.huangsam.payment

abstract class PaymentMethod : PayStrategy {
    abstract var balanceAmount: Int

    abstract fun method(): String

    override fun pay(paymentAmount: Int): Boolean {
        if (paymentAmount > balanceAmount) {
            return false
        }
        balanceAmount -= paymentAmount
        return true
    }

    override fun collectPaymentDetails() {
        println("Payments are made via ${method()}")
    }

    fun balance(): Int {
        return balanceAmount
    }
}
