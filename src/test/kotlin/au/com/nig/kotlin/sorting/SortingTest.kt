package au.com.nig.kotlin.sorting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SortingTest {

    @Test
    fun `test of bubblesort function algo`() {
        // Given
        val input = mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
        val expected = mutableListOf(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283)

        // When
        val result = Sorting.bubbleSort(input)

        assertEquals(expected, result)
    }

    @Test
    fun `test of selectSort function algo`() {
        // Given
        val input = mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
        val expected = mutableListOf(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283)

        // When
        val result = Sorting.selectionSort(input)

        assertEquals(expected, result)
    }

    @Test
    fun `test of insertionSort function algo`() {
        // Given
        val input = mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
        val expected = mutableListOf(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283)

        // When
        val result = Sorting.insertionSort(input)

        assertEquals(expected, result)
    }

    @Test
    fun `test of mergeSort function algo`() {
        // Given
        val input = mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0)
        val expected = mutableListOf(0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283)

        // When
        val result = Sorting.mergeSort(input)

        assertEquals(expected, result)
    }

}
