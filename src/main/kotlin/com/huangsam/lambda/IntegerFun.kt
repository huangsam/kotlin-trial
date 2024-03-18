package com.huangsam.lambda

object IntegerFun {
    fun filteredEvenCount(intList: List<Int>): Int {
        var evenCount = 0
        intList.filter { it % 2 == 0 }.forEach { _ ->
            evenCount += 1
        }
        return evenCount
    }

    fun scaleValues(intList: List<Int>, factor: Int): List<Int> =
        intList.map { it * factor }

    fun sumOfSquares(intList: List<Int>): Int =
        intList.fold(0) { acc, i -> acc + i * i }
}
