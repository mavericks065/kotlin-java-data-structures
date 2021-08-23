package au.com.nig.java.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeArrayTest {
    @Test
    public void mergeSortedArrays_should_keep_the_order_and_merge_arrays() {
        // Given
        Integer[] arr1 = {0, 3, 4, 31};
        Integer[] arr2 = {4, 6, 30};
        Integer[] expected = {0, 3, 4, 4, 6, 30, 31};

        // When
        var result = MergeArray.mergeSortedArrays(arr1, arr2);

        // Then
        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], result[i]);
    }

}
