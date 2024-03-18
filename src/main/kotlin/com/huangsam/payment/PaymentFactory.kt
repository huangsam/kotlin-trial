package com.huangsam.payment

class PaymentFactory {
    fun createFromMethodName(
        method: String,
        balanceAmount: Int,
    ): PaymentMethod {
        return when (method.lowercase()) {
            "google" -> GooglePay(balanceAmount)
            "apple" -> ApplePay(balanceAmount)
            else -> {
                throw UnsupportedOperationException("Method $method is not possible")
            }
        }
    }
}
