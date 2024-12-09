package recursion;

import java.util.ArrayList;
import java.util.List;

public class Task1_binarysearch {
    // Recursive binary search for integers
    public static int binarySearchRecursive(int[] array, int target, int low, int high) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        if (low > high) {
            return -1; // Base case: search range is empty
        }
        int mid = low + (high - low) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearchRecursive(array, target, low, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, high);
        }
    }

    // Recursive binary search for strings
    public static int binarySearchRecursive(String[] array, String target, int low, int high) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        if (low > high) {
            return -1; // Base case: search range is empty
        }
        int mid = low + (high - low) / 2;
        int comparison = array[mid].compareTo(target);
        if (comparison == 0) {
            return mid;
        } else if (comparison > 0) {
            return binarySearchRecursive(array, target, low, mid - 1);
        } else {
            return binarySearchRecursive(array, target, mid + 1, high);
        }
    }

    // Find all indices of a target value
    public static List<Integer> findAllIndices(int[] array, int target, int low, int high) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        List<Integer> indices = new ArrayList<>();
        findAllIndicesHelper(array, target, low, high, indices);
        return indices;
    }

    private static void findAllIndicesHelper(int[] array, int target, int low, int high, List<Integer> indices) {
        if (low > high) {
            return; // Base case
        }
        int mid = low + (high - low) / 2;
        if (array[mid] == target) {
            findAllIndicesHelper(array, target, low, mid - 1, indices); // Search left
            indices.add(mid); // Add current index
            findAllIndicesHelper(array, target, mid + 1, high, indices); // Search right
        } else if (array[mid] > target) {
            findAllIndicesHelper(array, target, low, mid - 1, indices);
        } else {
            findAllIndicesHelper(array, target, mid + 1, high, indices);
        }
    }
}
