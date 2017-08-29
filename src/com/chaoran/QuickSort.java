package com.chaoran;

/**
 * Created by chaoranli on 5/29/17.
 * time complexity: O(nlog^n) call the quicksorthelper method log^n times
 * space complexity: O(log^n) log^n times call stack
 */
public class QuickSort {

    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        quickSortHelper (array, 0, array.length - 1);
        return array;
    }

    public void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = left + (right - left) / 2;
        swap (array, pivotIndex, right); //swap the pivot to the most right index
        int pivot = array[right];
        int leftBound = left;
        int rightBound = right - 1;

        /**
         * when leftBound == rightBound, we do not know the number that pointer
         * indicate is smaller or bigger than pivot, so we need to check.
         */
        while (leftBound <= rightBound) {
            if (array[leftBound] <= pivot) {
                leftBound++;
            } else if (array[rightBound] >= pivot) {
                rightBound--;
            } else {
                swap (array, leftBound++, rightBound--);
            }
        }
        swap (array, leftBound, right);
        quickSortHelper (array, left, leftBound - 1);
        quickSortHelper (array, leftBound + 1, right);
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
