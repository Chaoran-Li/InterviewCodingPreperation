package com.chaoran;

/**
 * Created by chaoranli on 5/30/17.
 * time complexity: O(nlog^n) there are log^n times of divide
 * every divide has n times merge
 * space complexity: O(n) has n elements helper array and log^n times call stack
 * when n is approximately equal to infinite, n >> log^n
 * so O(n)
 */
public class MergeSort {

    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] temp = new int[array.length];
        mergeSortHelper(array, temp, 0, array.length - 1);
        return array;
    }

    private void mergeSortHelper(int[] array, int[] temp, int left, int right) {
        if (left >= right) { // keep dividing to one element left
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortHelper(array, temp, left, mid);
        mergeSortHelper(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid + 1;

        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        while (leftIndex <= mid && rightIndex <= right) {
            if (temp[leftIndex] < temp[rightIndex]) {
                array[left++] = temp[leftIndex++];
            } else {
                array[left++] = temp[rightIndex++];
            }
        }
        //if left side has elements left, copy them into array
        //if right side has elements left, leave them in the original place
        //because they are already in right place
        while (leftIndex <= mid) {
            array[left++] = temp[leftIndex++];
        }

    }
}
