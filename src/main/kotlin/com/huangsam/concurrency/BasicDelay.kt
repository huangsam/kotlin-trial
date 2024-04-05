package com.huangsam.concurrency

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("BasicDelay")

private const val FIVE = 5
private const val ONE_FIFTH = 200L
private const val ONE_HALF = 500L

// https://kotlinlang.org/docs/coroutines-basics.html#your-first-coroutine
suspend fun helloWorldWithDelay() =
    coroutineScope {
        launch {
            delay(ONE_FIFTH)
            logger.info("World!")
        }
        logger.info("Hello")
    }

// https://kotlinlang.org/docs/coroutines-basics.html#coroutines-are-light-weight
suspend fun numbersWithDelay() =
    coroutineScope {
        repeat(FIVE) {
            launch {
                val delayTime = ONE_HALF / (it + 1)
                delay(delayTime)
                logger.info("delay($delayTime) -> $it")
            }
        }
    }
