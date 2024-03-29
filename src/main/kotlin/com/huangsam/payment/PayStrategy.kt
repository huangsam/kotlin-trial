package com.huangsam.payment

import org.slf4j.Logger
import org.slf4j.LoggerFactory

private const val DEFAULT_BALANCE = 100

abstract class PayStrategy : Payable {
    abstract var balanceAmount: Int

    abstract fun company(): String

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun pay(paymentAmount: Int): Boolean {
        if (paymentAmount > balanceAmount) return false
        balanceAmount -= paymentAmount
        return true
    }

    override fun collectPaymentDetails() {
        logger.info("Payments are made via ${company()}")
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
