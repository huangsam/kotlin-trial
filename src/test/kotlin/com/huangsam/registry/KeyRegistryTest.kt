package com.huangsam.registry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val HELLO = "HELLO"
private const val WORLD = "WORLD"

class KeyRegistryTest {
    private val registry = KeyRegistry.getInstance()

    @BeforeEach
    fun beforeEach() {
        registry.clearValues()
    }

    @Test
    fun getWorldFromSetKey() {
        registry.setValue(HELLO, WORLD)
        val value = registry.getValue(HELLO)
        assertEquals(WORLD, requireNotNull(value))
    }

    @Test
    fun getNullFromEmptyKey() {
        val value = registry.getValue(HELLO)
        assertNull(value)
    }

    @Test
    fun getNullFromClearedKey() {
        registry.setValue(HELLO, WORLD)
        registry.clearValue(HELLO)
        val value = registry.getValue(HELLO)
        assertNull(value)
    }
}
