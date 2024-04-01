package com.huangsam.concurrency

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("BasicDelay")

// Described in great detail here
// https://kotlinlang.org/docs/coroutines-basics.html
suspend fun helloWorldWithDelay() =
    coroutineScope {
        launch {
            delay(200L)
            logger.info("World!")
        }
        logger.info("Hello")
    }

suspend fun numbersWithDelay() =
    coroutineScope {
        repeat(5) {
            launch {
                val delayTime = 500L / (it + 1)
                delay(delayTime)
                logger.info("delay($delayTime) -> $it")
            }
        }
    }
