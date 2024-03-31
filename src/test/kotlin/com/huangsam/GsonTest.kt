package com.huangsam

import com.google.gson.Gson
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GsonTest {
    private val gson = Gson()

    @Test
    fun tryPrimitivesSerialization() {
        assertEquals("1", gson.toJson(1))
        assertEquals("false", gson.toJson(false))
        assertEquals("10.05", gson.toJson(10.05))
        assertEquals("[1,2,3]", gson.toJson(listOf(1, 2, 3)))
    }

    @Test
    fun tryPrimitivesDeserialization() {
        assertEquals(1, gson.fromJson("1", Int::class.java))
        assertEquals(false, gson.fromJson("false", Boolean::class.java))
        assertEquals(10.05, gson.fromJson("10.05", Double::class.java))

        // Compare arrays with JUnit 5 - https://stackoverflow.com/a/68054311
        val parsedArray: Array<Int> = gson.fromJson("[1,2,3]", Array<Int>::class.java)
        assertArrayEquals(arrayOf(1, 2, 3), parsedArray)
    }
}
