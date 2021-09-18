package au.com.nig.kotlin.hashtable

import au.com.nig.kotlin.hashtable.FirstRecurring
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FirstRecurringTest {
    @Test
    fun `should find the first recurring character`() {
        // Given
        val arr0 = arrayOf(2, 5, 1, 2, 3, 5, 1, 2, 4)
        val arr1 = arrayOf(2, 1, 1, 2, 3, 5, 1)
        val arr2 = arrayOf(2, 5, 1, 4)

        // When
        val result0 = FirstRecurring.getFirstRecurringCharacter(arr0)
        val result1 = FirstRecurring.getFirstRecurringCharacter(arr1)
        val result2 = FirstRecurring.getFirstRecurringCharacter(arr2)

        // Then
        assertEquals(2, result0)
        assertEquals(1, result1)
        assertEquals(null, result2)
    }

}
