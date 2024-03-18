package com.huangsam.registry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class KeyRegistryTest {
    private val registry = KeyRegistry.getInstance()

    @BeforeEach
    fun beforeEach() {
        registry.clearValues()
    }

    @Test
    fun registrySetAndGetWorks() {
        registry.setValue("hello", "world")
        val value = registry.getValue("hello")
        assertEquals(requireNotNull(value), "world")
    }

    @Test
    fun getMissingKeyIsNull() {
        val value = registry.getValue("hello")
        assertNull(value)
    }
}
