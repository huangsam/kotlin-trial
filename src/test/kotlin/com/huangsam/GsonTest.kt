package com.huangsam

import com.google.gson.Gson
import com.huangsam.person.Engineer
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private fun Engineer.toJson(gson: Gson): String = gson.toJson(this)

class GsonTest {
    private val gson = Gson()

    private val joe = Engineer("Jason", 24)

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

    @Test
    fun tryObjectSerialization() {
        assertEquals(
            """{"certifications":[],"qualifications":[],"name":"Jason","age":24}""",
            joe.toJson(gson),
        )
    }

    @Test
    fun tryObjectDeserialization() {
        val person = gson.fromJson(joe.toJson(gson), Engineer::class.java)
        assertEquals(joe.name, person.name)
        assertEquals(joe.isReadyToVote(), person.isReadyToVote())
    }
}
