package com.huangsam.person

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.read.ListAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class EngineerTest {
    private val john = Engineer("John", 26, certifications = listOf("Stanford", "Yale"))
    private val mary = Engineer("Mary", 18, certifications = listOf("Coding Dojo"))
    private val jack = Engineer("Jack", 16)

    // Logback testing - https://stackoverflow.com/a/52229629
    private val logger = LoggerFactory.getLogger(Engineer::class.java) as Logger
    private val appender = ListAppender<ILoggingEvent>()

    private fun assertLastContent(result: String) {
        assertEquals(appender.list.last().message, result)
    }

    @BeforeEach
    fun setupAppender() {
        appender.start()
        logger.addAppender(appender)
    }

    @AfterEach
    fun clearAppender() {
        logger.detachAppender(appender)
        appender.stop()
        appender.list.clear()
    }

    @Test
    fun engineerWorkWithLog() {
        john.work()
        assertLastContent("${john.name} is coding")
    }

    @Test
    fun engineerRunWithLog() {
        john.run()
        assertLastContent("${john.name} is running")
    }

    @Test
    fun engineerWalkWithLog() {
        john.walk()
        assertLastContent("${john.name} is walking")
    }

    @Test
    fun engineerEatWithLog() {
        john.eat()
        assertLastContent("${john.name} is eating")
    }

    @Test
    fun engineerSleepWithLog() {
        john.sleep()
        assertLastContent("${john.name} is sleeping")
    }

    @Test
    fun engineerCanVote() {
        assertTrue(john.isReadyToVote())
        assertTrue(mary.isReadyToVote())
    }

    @Test
    fun engineerCannotVote() {
        assertFalse(jack.isReadyToVote())
    }

    @Test
    fun engineerIsTrusted() {
        assertTrue(john.isTrusted())
        assertTrue(mary.isTrusted())
    }

    @Test
    fun engineerIsNotTrusted() {
        assertFalse(jack.isTrusted())
    }

    @Test
    fun engineerIsIntern() {
        assertTrue(jack.isIntern())
    }
}
