package com.huangsam.person

class Engineer(
    name: String,
    age: Int,
    certifications: List<String> = listOf(),
    qualifications: List<String> = listOf(),
) : Professional(name, age, certifications, qualifications) {
    override fun work() = logger.info("${this.name} is coding")
}
