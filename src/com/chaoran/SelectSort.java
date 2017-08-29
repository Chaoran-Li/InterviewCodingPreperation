package com.chaoran;

/**
 * Created by chaoranli on 6/7/17.
 * time complexity: O(n^2) because of nesting for loop
 * space complexity: O(1) there is no extra space use
 *
 * for the beginning, set the first element for globalMin
 * find the minimum in the sub-array except the first one
 * update the minimum to globalMin and swap with first
 *
 */
public class SelectSort {

    public int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int globalMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[globalMin]) {
                    globalMin = j;
                }
            }
            swap(array, i, globalMin); // out of bounds??
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = array[temp];
    }
}
