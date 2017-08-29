package com.chaoran;

/**
 * Created by chaoranli on 8/21/17.
 */
public class LargestAndSmallest {
    /**
     * find an array the largest and smallest elements
     * assume the array is not null and at least has a element
     * time complexity: O(2n)
     * space complexity: O(1)
     */
    public int[] largestAndSmallest(int[] array) {
         if (array.length == 1) {
             int[] result = new int[array.length + 1];
             result[0] = array[0];
             result[1] = array[0];
             return result;
         }

         int max = 0;
         for (int i = 1; i < array.length; i++) {
             if (array[max] < array[i]) {
                 swap(array, max, i);
             }
         }

         int min = 1;
         for (int j = 2; j < array.length; j++) {
             if (array[min] > array[j]) {
                 swap(array, min, j);
             }
         }
         return array;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    /**
     * assume array is not null
     * time complexity: O(1.5n)
     */
    public int[] largestAndSmallestI(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                swap(array, i, n - 1 - i);
            }
        }
        return new int[] {largest(array, 0, n - 1 / 2), smallest(array, n / 2, n - 1)};
    }

    private int largest(int[] array, int left, int right) {
        int largest = left;
        for (int i = left + 1; i <= right; i++) {
            largest = Math.max(largest, array[i]);
        }
        return largest;
    }

    private int smallest(int[] array, int left, int right) {
        int smallest = left;
        for (int i = left + 1; i <= right; i++) {
            smallest = Math.min(smallest, array[i]);
        }
        return smallest;
    }
}
