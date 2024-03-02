package com.huangsam.payment

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ApplePayTest {

    private val originalAmount = 100
    private var applePay = ApplePay(originalAmount)

    @BeforeEach
    fun beforeEach() {
        applePay = ApplePay(originalAmount)
    }

    @Test
    fun method() {
        assertEquals(applePay.method(), "Apple Incorporated")
    }

    @Test
    fun getBalanceAmount() {
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
        assertFalse(applePay.pay(110))
    }
}
