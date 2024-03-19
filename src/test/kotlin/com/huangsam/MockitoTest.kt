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

@ExtendWith(MockitoExtension::class)
class MockitoTest {
    @Mock
    private var mockedList: MutableList<Int> = mutableListOf()

    @Spy
    private var spyList: MutableList<Int> = mutableListOf()

    private val one = 1
    private val two = 2
    private val three = 3
    private val four = 4
    private val twoHundred = 200

    @BeforeEach
    fun resetMockitoAssets() {
        reset(mockedList, spyList)
        spyList.clear()
    }

    @Test
    fun checkAddCountWithMockedList() {
        mockedList.add(one)
        verify(mockedList).add(one)
        assertEquals(0, mockedList.count())
        whenever(mockedList.count()).thenReturn(twoHundred)
        assertEquals(twoHundred, mockedList.count())
    }

    @Test
    fun checkAddCountWithSpyList() {
        spyList.add(one)
        spyList.add(two)
        verify(spyList).add(one)
        verify(spyList).add(two)
        assertEquals(2, spyList.count())
        whenever(mockedList.count()).thenReturn(twoHundred)
        assertEquals(twoHundred, mockedList.count())
    }

    @Test
    fun checkAddWithArgumentCaptor() {
        val captor = argumentCaptor<Int>()
        mockedList.add(one)
        mockedList.add(two)
        mockedList.add(three)
        mockedList.add(four)
        captor.apply {
            verify(mockedList, times(four)).add(capture())
            assertEquals(one, firstValue)
            assertEquals(two, secondValue)
            assertEquals(three, thirdValue)
            assertEquals(four, lastValue)
        }
    }
}
