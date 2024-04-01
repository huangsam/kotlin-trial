package com.huangsam.person

// Additional context on internal visibility
// https://kotlinlang.org/docs/visibility-modifiers.html#modules
internal fun <T : Professional> T.isIntern(): Boolean = !isTrusted()

abstract class Professional(
    name: String,
    age: Int,
    private val certifications: List<String>,
) : Person(name, age) {
    abstract fun work()

    fun isTrusted(): Boolean = certifications.isNotEmpty()
}
