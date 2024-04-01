package com.huangsam.concurrency

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("BasicDelay")

// https://kotlinlang.org/docs/coroutines-basics.html#your-first-coroutine
suspend fun helloWorldWithDelay() =
    coroutineScope {
        launch {
            delay(200L)
            logger.info("World!")
        }
        logger.info("Hello")
    }

// https://kotlinlang.org/docs/coroutines-basics.html#coroutines-are-light-weight
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
