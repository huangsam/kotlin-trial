package com.huangsam.payment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val START_AMOUNT = 100

class ApplePayTest {
    private var applePay = ApplePay(START_AMOUNT)

    @BeforeEach
    fun resetApplePay() {
        applePay = ApplePay(START_AMOUNT)
    }

    @Test
    fun balanceMatchesOriginal() {
        assertEquals(START_AMOUNT, applePay.getBalance())
    }

    @Test
    fun payUnderSuccess() {
        assertTrue(applePay.makePayment(10))
    }

    @Test
    fun payExactSuccess() {
        assertTrue(applePay.makePayment(START_AMOUNT))
    }

    @Test
    fun payOverFailure() {
        assertFalse(applePay.makePayment(START_AMOUNT + 1))
    }
}
