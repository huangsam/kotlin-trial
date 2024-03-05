package com.huangsam.registry

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class KeyRegistryTest {
    @BeforeEach
    fun beforeEach() {
        KeyRegistry.clearValues()
    }

    @Test
    fun getRegisteredKey() {
        KeyRegistry.setValue("hello", "world")
        val value = KeyRegistry.getValue("hello")
        assertTrue(value is String && value.startsWith("wo"))
    }

    @Test
    fun getMissingKey() {
        val value = KeyRegistry.getValue("hello")
        assertNull(value)
    }
}
