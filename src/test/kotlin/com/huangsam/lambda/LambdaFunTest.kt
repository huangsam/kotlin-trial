package com.huangsam.lambda

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LambdaFunTest {
    @Test
    fun filteredEvenCountMatchesAll() {
        val data = listOf(2, 4, 6, 8)
        val result = LambdaFun.filteredEvenCount(data)
        assertTrue(data.size == result)
    }

    @Test
    fun filteredEvenCountMatchesSome() {
        val data = listOf(1, 2, 3, 4)
        val result = LambdaFun.filteredEvenCount(data)
        assertTrue(data.size > result && result > 0)
    }

    @Test
    fun filteredEvenCountMatchesNone() {
        val data = listOf(1, 3, 5, 7)
        val result = LambdaFun.filteredEvenCount(data)
        assertTrue(result == 0)
    }
}
