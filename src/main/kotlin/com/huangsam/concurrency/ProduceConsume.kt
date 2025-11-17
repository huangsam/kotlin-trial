package com.huangsam.concurrency

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("ProduceConsume")

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) {
        delay(100) // Simulate work
        send(x * x) // send() is a suspending function
        logger.info("Producer sent: ${x * x}")
    }
}

fun main() = runBlocking {
    val squaresChannel = produceSquares() // Create the producer/channel

    // The main coroutine acts as the consumer
    logger.info("Consumer is starting to receive data.")
    for (value in squaresChannel) {
        // The consumer suspends until a value is available
        logger.info("Consumer received: $value")
    }

    logger.info("Done receiving and processing!")
}
