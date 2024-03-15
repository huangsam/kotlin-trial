package com.huangsam.lambda

object LambdaFun {
    fun filteredEvenCount(intList: List<Int>): Int {
        var evenCount = 0
        intList.filter { it % 2 == 0 }.forEach {
            evenCount += 1
        }
        return evenCount
    }
}
