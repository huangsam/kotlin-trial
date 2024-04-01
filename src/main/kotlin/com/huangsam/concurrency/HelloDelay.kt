package com.huangsam.concurrency

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("HelloDelay")

// Described in great detail here
// https://kotlinlang.org/docs/coroutines-basics.html
suspend fun helloWorldWithDelay() =
    coroutineScope {
        launch {
            delay(250L)
            logger.info("World!")
        }
        logger.info("Hello")
    }
