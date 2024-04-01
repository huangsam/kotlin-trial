package com.huangsam

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.reset
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

private const val ONE = 1
private const val TWO = 2
private const val THREE = 3
private const val FOUR = 4
private const val TWO_HUNDRED = 200

@ExtendWith(MockitoExtension::class)
class MockitoTest {
    @Mock
    private var mockedList: MutableList<Int> = mutableListOf()

    @Spy
    private var spyList: MutableList<Int> = mutableListOf()

    @BeforeEach
    fun resetMockitoAssets() {
        reset(mockedList, spyList)
        spyList.clear()
    }

    @Test
    fun checkAddCountWithMockedList() {
        mockedList.add(ONE)
        verify(mockedList).add(ONE)
        assertEquals(0, mockedList.count())
        whenever(mockedList.count()).thenReturn(TWO_HUNDRED)
        assertEquals(TWO_HUNDRED, mockedList.count())
    }

    @Test
    fun checkAddCountWithSpyList() {
        spyList.add(ONE)
        spyList.add(TWO)
        verify(spyList).add(ONE)
        verify(spyList).add(TWO)
        assertEquals(2, spyList.count())
        whenever(mockedList.count()).thenReturn(TWO_HUNDRED)
        assertEquals(TWO_HUNDRED, mockedList.count())
    }

    @Test
    fun checkAddWithArgumentCaptor() {
        val captor = argumentCaptor<Int>()
        mockedList.add(ONE)
        mockedList.add(TWO)
        mockedList.add(THREE)
        mockedList.add(FOUR)
        captor.apply {
            verify(mockedList, times(FOUR)).add(capture())
            assertEquals(ONE, firstValue)
            assertEquals(TWO, secondValue)
            assertEquals(THREE, thirdValue)
            assertEquals(FOUR, lastValue)
        }
    }
}
