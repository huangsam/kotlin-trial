package com.huangsam.person

// Additional context on internal visibility
// https://kotlinlang.org/docs/visibility-modifiers.html#modules
internal fun Professional.isIntern(): Boolean = !isCertified()

abstract class Professional(
    name: String,
    age: Int,
    private val certifications: List<String>,
) : Person(name, age) {
    abstract fun work()

    fun isCertified(): Boolean = certifications.isNotEmpty()
}
