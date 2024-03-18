package com.huangsam.payment

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ApplePayTest {
    private val originalAmount = 100
    private var applePay = ApplePay(originalAmount)

    @BeforeEach
    fun beforeEach() {
        applePay = ApplePay(originalAmount)
    }

    @Test
    fun balanceMatchesOriginal() {
        assertEquals(applePay.balance(), originalAmount)
    }

    @Test
    fun payUnderSuccess() {
        assertTrue(applePay.pay(10))
    }

    @Test
    fun payExactSuccess() {
        assertTrue(applePay.pay(originalAmount))
    }

    @Test
    fun payOverFailure() {
        assertFalse(applePay.pay(originalAmount + 1))
    }
}
