package com.chaoran;

/**
 * Created by chaoranli on 9/13/17.
 * time complexity: O(1.5n)
 * space complexity: O(1)
 */
public class LargestAndSecondLargest {

    public int[] largestAndSecondLargest(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                swap(array, i, n - 1 - i);
            }
        }
        return new int[]{largest(array, 0, (n - 1) / 2), secondLargest(array, 1, n - 1)};
    }

    private int largest(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            if (array[left] < array[i]) {
                swap(array, left, i);
            }
        }
        return array[left];
    }

    private int secondLargest(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            if (array[left] < array[i]) {
                swap(array, left, i);
            }
        }
        return array[left];
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
