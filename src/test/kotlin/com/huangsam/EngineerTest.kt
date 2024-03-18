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

    // https://stackoverflow.com/q/1119385
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
        assertEquals("$name is coding\n", outContent.toString())
    }

    @Test
    fun engineerCanRun() {
        engineer.run()
        assertEquals("$name is running\n", outContent.toString())
    }

    @Test
    fun engineerCanWalk() {
        engineer.walk()
        assertEquals("$name is walking\n", outContent.toString())
    }

    @Test
    fun engineerCanEat() {
        engineer.eat()
        assertEquals("$name is eating\n", outContent.toString())
    }

    @Test
    fun engineerCanSleep() {
        engineer.sleep()
        assertEquals("$name is sleeping\n", outContent.toString())
    }
}
