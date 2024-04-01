package com.huangsam.concurrency

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("HelloDelay")

// Described in great detail here
// https://kotlinlang.org/docs/coroutines-basics.html
fun helloWorldWithDelay() =
    runBlocking {
        launch { logWorld() }
        logger.info("Hello")
    }

suspend fun logWorld() {
    delay(250L)
    logger.info("World!")
}
