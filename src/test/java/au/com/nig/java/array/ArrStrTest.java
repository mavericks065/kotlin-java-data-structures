package au.com.nig.java.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrStrTest {
    @Test
    public void reverse_string_should_reverse_a_string() {
        // Given
        var input = "Hello";
        // When
        var result = ArrStr.reverse(input);
        // Then
        assertEquals("olleH", result);
    }
    @Test
    public void reverse_string_should_return_empty_string_when_input_is_null() {
        // Given
        String input = null;
        // When
        var result = ArrStr.reverse(input);
        // Then
        assertEquals("", result);
    }

    @Test
    public void reverse_string_with_Java_methods_should_reverse_a_string() {
        // Given
        var input = "Hello";
        // When
        var result = ArrStr.reverseUsingJava(input);
        // Then
        assertEquals("olleH", result);
    }

    @Test
    public void reverse_string_with_Java_methods_should_return_empty_string_when_input_is_null() {
        // Given
        String input = null;
        // When
        var result = ArrStr.reverseUsingJava(input);
        // Then
        assertEquals("", result);
    }
}
