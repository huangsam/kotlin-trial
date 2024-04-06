package com.huangsam.concurrency

import org.junit.jupiter.api.Assertions.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(
    ExperimentalCoroutinesApi::class,
    ExperimentalTime::class)
class BasicDelayTest {
    @Test
    fun helloLogicRunsFifthSecond() = runTest {
        testScheduler.timeSource.measureTime {
            helloWorldWithDelay()
        }
        testScheduler.runCurrent()
        assertEquals(ONE_FIFTH, currentTime)
    }

    @Test
    fun numberLogicRunsHalfSecond() = runTest {
        testScheduler.timeSource.measureTime {
            numbersWithDelay()
        }
        testScheduler.runCurrent()
        assertEquals(ONE_HALF, currentTime)
    }
}
