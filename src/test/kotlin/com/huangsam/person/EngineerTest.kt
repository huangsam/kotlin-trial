package com.huangsam.person

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
    private val contentOut = ByteArrayOutputStream()
    private val originalOut = System.out

    private fun assertContent(result: String) {
        assertEquals(result, contentOut.toString())
    }

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(contentOut))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
    }

    @Test
    fun engineerCanCode() {
        engineer.code()
        assertContent("$name is coding\n")
    }

    @Test
    fun engineerCanRun() {
        engineer.run()
        assertContent("$name is running\n")
    }

    @Test
    fun engineerCanWalk() {
        engineer.walk()
        assertContent("$name is walking\n")
    }

    @Test
    fun engineerCanEat() {
        engineer.eat()
        assertContent("$name is eating\n")
    }

    @Test
    fun engineerCanSleep() {
        engineer.sleep()
        assertContent("$name is sleeping\n")
    }
}
