package com.huangsam.registry

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class KeyRegistryTest {
    @BeforeEach
    fun beforeEach() {
        KeyRegistry.clearValues()
    }

    @Test
    fun registrySetAndGetWorks() {
        KeyRegistry.setValue("hello", "world")
        val value = KeyRegistry.getValue("hello")
        assertTrue(value is String && value.startsWith("wo"))
    }

    @Test
    fun getMissingKeyIsNull() {
        val value = KeyRegistry.getValue("hello")
        assertNull(value)
    }
}
