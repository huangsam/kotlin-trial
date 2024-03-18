package com.huangsam.payment

import Constants.DEFAULT_BALANCE

abstract class PayStrategy : Payable {
    abstract var balanceAmount: Int

    abstract fun company(): String

    override fun pay(paymentAmount: Int): Boolean {
        if (paymentAmount > balanceAmount) return false
        balanceAmount -= paymentAmount
        return true
    }

    override fun collectPaymentDetails() {
        println("Payments are made via ${company()}")
    }

    fun balance(): Int {
        return balanceAmount
    }

    companion object Factory {
        fun createFromMethod(
            method: PaymentMethod,
            balanceAmount: Int = DEFAULT_BALANCE,
        ): PayStrategy {
            return when (method) {
                PaymentMethod.APPLE -> ApplePay(balanceAmount)
                PaymentMethod.GOOGLE -> GooglePay(balanceAmount)
            }
        }
    }
}
