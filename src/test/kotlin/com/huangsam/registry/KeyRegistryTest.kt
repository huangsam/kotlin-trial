package com.huangsam.registry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class KeyRegistryTest {
    private val registry = KeyRegistry.getInstance()

    private val hello = "hello"
    private val world = "world"

    @BeforeEach
    fun beforeEach() {
        registry.clearValues()
    }

    @Test
    fun getWorldFromSetKey() {
        registry.setValue(hello, world)
        val value = registry.getValue(hello)
        assertEquals(world, requireNotNull(value))
    }

    @Test
    fun getNullFromEmptyKey() {
        val value = registry.getValue(hello)
        assertNull(value)
    }

    @Test
    fun getNullFromClearedKey() {
        registry.setValue(hello, world)
        registry.clearValue(hello)
        val value = registry.getValue(hello)
        assertNull(value)
    }
}
