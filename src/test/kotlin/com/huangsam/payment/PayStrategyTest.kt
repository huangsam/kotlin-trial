package com.huangsam.payment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PayStrategyTest {
    @Test
    fun createApplyPay() {
        val pay = PayStrategy.create(PaymentMethod.APPLE)
        assertTrue(pay is ApplePay)
        assertEquals(pay.company, "Apple Incorporated")
    }

    @Test
    fun createGooglePay() {
        val pay = PayStrategy.create(PaymentMethod.GOOGLE)
        assertTrue(pay is GooglePay)
        assertEquals(pay.company, "Google LLC")
    }
}
