package com.huangsam

import com.google.gson.Gson
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GsonTest {
    @Test
    fun tryPrimitives() {
        val gson = Gson()
        assertEquals("1", gson.toJson(1))
    }
}
