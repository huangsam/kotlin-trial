package com.huangsam.lambda

fun List<Int>.evenCount(): Int = this.filter { it % 2 == 0 }.fold(0) { acc, _ -> acc + 1 }

fun List<Int>.scaleBy(factor: Int): List<Int> = this.map { it * factor }

fun List<Int>.sumSquares(): Int = this.fold(0) { acc, i -> acc + i * i }

object IntegerFun {
    fun filteredEvenCount(list: List<Int>): Int {
        var count = 0
        list.map { if (it % 2 == 0) count += 1 }
        return count
    }

    fun scaleValues(
        list: List<Int>,
        factor: Int,
    ): List<Int> {
        val transform: MutableList<Int> = mutableListOf()
        list.map { transform.add(it * factor) }
        return transform
    }

    fun sumOfSquares(list: List<Int>): Int {
        var sum = 0
        list.map { sum += it * it }
        return sum
    }
}
