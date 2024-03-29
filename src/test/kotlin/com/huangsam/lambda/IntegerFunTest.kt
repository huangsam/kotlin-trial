package com.huangsam.lambda

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.random.Random

class IntegerFunTest {
    private val oneToFour = (1..4).toList()
    private val allEven = (2..8 step 2).toList()
    private val allOdd = (1..7 step 2).toList()

    private val randomInt
        get() = Random.nextInt()

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
        assertTrue(result.all { it == 0 })
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 25, 125])
    fun scaleValuesWithPositiveFactor(positiveFactor: Int) {
        val result = IntegerFun.scaleValues(oneToFour, positiveFactor)
        assertTrue(result.all { it > 0 })
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -3, -9, -27])
    fun scaleValuesWithNegativeFactor(negativeFactor: Int) {
        val result = IntegerFun.scaleValues(oneToFour, negativeFactor)
        assertTrue(result.all { it < 0 })
    }

    @Test
    fun sumOfSquaresIsCorrect() {
        val result = IntegerFun.sumOfSquares(oneToFour)
        assertEquals(1 + 4 + 9 + 16, result)
    }

    @Test
    fun evenCountLambdaMatchesFun() {
        assertEquals(oneToFour.evenCount(), IntegerFun.filteredEvenCount(oneToFour))
    }

    @Test
    fun scaleLambdaMatchesFun() {
        repeat(times = 10) {
            val factor = randomInt
            assertEquals(oneToFour.scaleBy(factor), IntegerFun.scaleValues(oneToFour, factor))
        }
    }

    @Test
    fun sumSquareLambdaMatchesFun() {
        assertEquals(oneToFour.sumSquares(), IntegerFun.sumOfSquares(oneToFour))
    }
}
