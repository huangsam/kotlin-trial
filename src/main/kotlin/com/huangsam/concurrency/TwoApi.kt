package com.huangsam.concurrency

import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis

private val logger: Logger = LoggerFactory.getLogger("TwoApi")

suspend fun fetchUserDetails(): String {
    // Simulates fetching user details from a network
    delay(1500L)
    return "User: Jane Doe"
}

suspend fun fetchPosts(): String {
    // Simulates fetching user's blog posts
    delay(1000L)
    return "Posts: 5 new articles"
}

suspend fun loadUserDataParallel() = coroutineScope {
    val time = measureTimeMillis {
        // 1. Start both tasks concurrently using async
        val userDeferred = async(Dispatchers.IO) { fetchUserDetails() }
        val postsDeferred = async(Dispatchers.IO) { fetchPosts() }

        logger.info("Waiting for both tasks to complete...")

        // 2. Await both results. This suspends the coroutine until both are done.
        val userResult = userDeferred.await()
        val postsResult = postsDeferred.await()

        logger.info("Results combined: $userResult, $postsResult")
    }
    // The total time will be close to the longest task (1500ms), not the sum (2500ms)
    logger.info("Total time taken: $time ms")
}
