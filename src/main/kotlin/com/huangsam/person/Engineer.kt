package com.huangsam.person

class Engineer(
    name: String,
    age: Int,
    certifications: List<String> = listOf(),
) : Professional(name, age, certifications) {
    override fun work() = logger.info("${this.name} is coding")
}
