package com.huangsam.lambda

object IntegerFun {
    fun filteredEvenCount(intList: List<Int>): Int = intList.filter { it % 2 == 0 }.fold(0) { acc, _ -> acc + 1 }

    fun scaleValues(
        intList: List<Int>,
        factor: Int,
    ): List<Int> = intList.map { it * factor }

    fun sumOfSquares(intList: List<Int>): Int = intList.fold(0) { acc, i -> acc + i * i }
}
