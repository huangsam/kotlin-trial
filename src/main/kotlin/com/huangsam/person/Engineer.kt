package com.huangsam.person

class Engineer(firstName: String) : Person(firstName) {
    fun code() = printer.println("${this.firstName} is coding")
}
