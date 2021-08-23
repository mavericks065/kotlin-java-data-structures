package au.com.nig.kotlin.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ArrStr2Test {
    @Test
    fun `reverse string in kotlin using built in functions`() {
        // Given
        val input = "Hello"
        //When
        val result = ArrStr2.reverseString(input)
        // Then
        assertEquals("olleH", result)
    }
}
