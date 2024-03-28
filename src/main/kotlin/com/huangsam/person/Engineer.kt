package com.huangsam.person

class Engineer(firstName: String) : Person(firstName) {
    fun code() = logger.info("${this.firstName} is coding")
}
