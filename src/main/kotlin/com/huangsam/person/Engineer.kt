package com.huangsam.person

class Engineer(name: String, age: Int) : Person(name, age) {
    fun code() = logger.info("${this.name} is coding")
}
