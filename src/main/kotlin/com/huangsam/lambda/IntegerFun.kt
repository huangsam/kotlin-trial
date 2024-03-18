package com.huangsam.lambda

object IntegerFun {
    fun filteredEvenCount(list: List<Int>): Int = list.filter { it % 2 == 0 }.fold(0) { acc, _ -> acc + 1 }

    fun scaleValues(
        list: List<Int>,
        factor: Int,
    ): List<Int> = list.map { it * factor }

    fun sumOfSquares(list: List<Int>): Int = list.fold(0) { acc, i -> acc + i * i }
}
