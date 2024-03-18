package com.huangsam.lambda

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class IntegerFunTest {
    private val oneToFour = (1..4).toList()
    private val allEven = (2..8 step 2).toList()
    private val allOdd = (1..7 step 2).toList()

    @Test
    fun filteredEvenCountMatchesAll() {
        val result = IntegerFun.filteredEvenCount(allEven)
        assertTrue(allEven.size == result)
    }

    @Test
    fun filteredEvenCountMatchesSome() {
        val result = IntegerFun.filteredEvenCount(oneToFour)
        assertTrue(oneToFour.size > result && result > 0)
    }

    @Test
    fun filteredEvenCountMatchesNone() {
        val result = IntegerFun.filteredEvenCount(allOdd)
        assertTrue(result == 0)
    }

    @Test
    fun scaleValuesWithZeroFactor() {
        val result = IntegerFun.scaleValues(oneToFour, 0)
        assertTrue(result.all { it -> it == 0 })
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 25, 125])
    fun scaleValuesWithPositiveFactor(factorValue: Int) {
        val result = IntegerFun.scaleValues(oneToFour, factorValue)
        assertTrue(result.all { it -> it > 0 })
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -3, -9, -27])
    fun scaleValuesWithNegativeFactor() {
        val result = IntegerFun.scaleValues(oneToFour, -3)
        assertTrue(result.all { it -> it < 0 })
    }

    @Test
    fun sumOfSquaresIsCorrect() {
        val result = IntegerFun.sumOfSquares(oneToFour)
        assertEquals(result, 1 + 4 + 9 + 16)
    }
}
