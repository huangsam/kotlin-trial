package com.huangsam

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.reset
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
class MockitoTest {
    @Mock
    private var mockedList: MutableList<Int> = mutableListOf()

    @Spy
    private var spyList: MutableList<Int> = mutableListOf()

    @BeforeEach
    fun resetMockitoAssets() {
        reset(mockedList)
        spyList.clear()
    }

    @Test
    fun checkAddCountWithVerify() {
        mockedList.add(1)
        verify(mockedList).add(1)
        assertEquals(0, mockedList.count())
        whenever(mockedList.count()).thenReturn(200)
        assertEquals(200, mockedList.count())
    }

    @Test
    fun checkAddCountWithSpy() {
        spyList.add(1)
        spyList.add(2)
        verify(spyList).add(1)
        verify(spyList).add(2)
        assertEquals(2, spyList.count())
    }
}
