package com.huangsam

import com.huangsam.person.Engineer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class EngineerTest {
    private val name = "John"
    private val engineer = Engineer(name)

    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
    }

    @Test
    fun engineerCanCode() {
        engineer.code()

        // https://stackoverflow.com/q/1119385
        assertEquals("$name is coding\n", outContent.toString())
    }
}
