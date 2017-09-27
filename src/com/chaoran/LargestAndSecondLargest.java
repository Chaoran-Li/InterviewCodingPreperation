package com.chaoran;

/**
 * Created by chaoranli on 9/13/17.
 * time complexity: O(1.5n)
 * space complexity: O(1)
 */
public class LargestAndSecondLargest {

    public int[] largestAndSecondLargest(int[] array) {
        // assumption: array is not null and length is at least 2
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                swap(array, i, n - 1 - i);
            }
        }
        int[] res = new int[2];
        return largestAndSecond(array, 0, (n - 1) / 2, res);
    }

    private int[] largestAndSecond(int[] array, int left, int right, int[] res) {
        int largest = array[left];
        int secondLargest = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (largest < array[i]) {
                secondLargest = largest;
                largest = array[i];
            } else {
                if (array[i] > secondLargest) {
                    secondLargest = array[i];
                }
            }
        }
        res[0] = largest;
        res[1] = secondLargest;
        return res;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
