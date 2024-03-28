package com.huangsam.person

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.read.ListAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class EngineerTest {
    private val engineer = Engineer("John")

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
    fun engineerCanCode() {
        engineer.code()
        assertLastContent("${engineer.firstName} is coding")
    }

    @Test
    fun engineerCanRun() {
        engineer.run()
        assertLastContent("${engineer.firstName} is running")
    }

    @Test
    fun engineerCanWalk() {
        engineer.walk()
        assertLastContent("${engineer.firstName} is walking")
    }

    @Test
    fun engineerCanEat() {
        engineer.eat()
        assertLastContent("${engineer.firstName} is eating")
    }

    @Test
    fun engineerCanSleep() {
        engineer.sleep()
        assertLastContent("${engineer.firstName} is sleeping")
    }
}
