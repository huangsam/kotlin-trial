package com.huangsam.payment

import Constants.DEFAULT_BALANCE

abstract class PayStrategy : Payable {
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

    companion object Factory {
        fun createFromMethodName(
            method: PaymentMethod,
            balanceAmount: Int = DEFAULT_BALANCE,
        ): PayStrategy {
            return when (method) {
                PaymentMethod.GOOGLE -> GooglePay(balanceAmount)
                PaymentMethod.APPLE -> ApplePay(balanceAmount)
                else -> {
                    throw UnsupportedOperationException("Method $method is not possible")
                }
            }
        }
    }
}
