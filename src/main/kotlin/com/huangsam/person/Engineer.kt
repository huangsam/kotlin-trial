package com.huangsam.person

class Engineer(firstName: String) : Person(firstName) {
    fun code() = println("${this.firstName} is coding")
}
