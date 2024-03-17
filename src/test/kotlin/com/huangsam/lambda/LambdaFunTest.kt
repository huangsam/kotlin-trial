package com.huangsam.lambda

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LambdaFunTest {
    private val oneToFour = (1..4).toList()
    private val allEven = (2..8 step 2).toList()
    private val allOdd = (1..7 step 2).toList()

    @Test
    fun filteredEvenCountMatchesAll() {
        val result = LambdaFun.filteredEvenCount(allEven)
        assertTrue(allEven.size == result)
    }

    @Test
    fun filteredEvenCountMatchesSome() {
        val result = LambdaFun.filteredEvenCount(oneToFour)
        assertTrue(oneToFour.size > result && result > 0)
    }

    @Test
    fun filteredEvenCountMatchesNone() {
        val result = LambdaFun.filteredEvenCount(allOdd)
        assertTrue(result == 0)
    }

    @Test
    fun scaleValuesWithZeroFactor() {
        val result = LambdaFun.scaleValues(oneToFour, 0)
        assertTrue(result.all { it -> it == 0 })
    }

    @Test
    fun scaleValuesWithPositiveFactor() {
        val result = LambdaFun.scaleValues(oneToFour, 2)
        assertTrue(result.all { it -> it > 0 })
    }

    @Test
    fun scaleValuesWithNegativeFactor() {
        val result = LambdaFun.scaleValues(oneToFour, -3)
        assertTrue(result.all { it -> it < 0 })
    }
}
