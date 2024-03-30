package com.huangsam.payment

import org.slf4j.Logger
import org.slf4j.LoggerFactory

private const val DEFAULT_BALANCE = 100

abstract class PayStrategy(private var balance: Int) : Payable {
    abstract val company: String

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun makePayment(paymentAmount: Int): Boolean {
        if (paymentAmount > balance) return false
        balance -= paymentAmount
        return true
    }

    fun getBalance(): Int {
        return balance
    }

    fun displayInfo() {
        logger.info("Payments are made via $company")
    }

    companion object Factory {
        fun create(method: PaymentMethod, balance: Int = DEFAULT_BALANCE): PayStrategy {
            return when (method) {
                PaymentMethod.APPLE -> ApplePay(balance)
                PaymentMethod.GOOGLE -> GooglePay(balance)
            }
        }
    }
}
