package recursion;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class Task1_binarysearchtest {
    @Test
    public void testBinarySearchRecursiveInt() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(3, Task1_binarysearch.binarySearchRecursive(array, 4, 0, array.length - 1));
        assertEquals(-1, Task1_binarysearch.binarySearchRecursive(array, 10, 0, array.length - 1));
    }

    @Test
    public void testBinarySearchRecursiveString() {
        String[] array = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(2, Task1_binarysearch.binarySearchRecursive(array, "cherry", 0, array.length - 1));
        assertEquals(-1, Task1_binarysearch.binarySearchRecursive(array, "fig", 0, array.length - 1));
    }

    @Test
    public void testFindAllIndices() {
        int[] array = {1, 2, 3, 3, 3, 4, 5};
        List<Integer> indices = Task1_binarysearch.findAllIndices(array, 3, 0, array.length - 1);
        assertEquals(java.util.Arrays.asList(2, 3, 4), indices);

        List<Integer> noIndices = Task1_binarysearch.findAllIndices(array, 10, 0, array.length - 1);
        assertTrue(noIndices.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArray() {
        Task1_binarysearch.binarySearchRecursive((int[]) null, 1, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArray() {
        Task1_binarysearch.binarySearchRecursive(new int[0], 1, 0, 0);
    }
}
