package com.chaoran;

/**
 * Created by chaoranli on 8/22/17.
 * move 0's to the right end of the array, no need to keep the original order
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class MoveZeroI {

    public int[] moveZero(int[] array) {
        // assume the given array is not null
        if (array.length <= 1) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] != 0) {
                left++;
            } else if (array[right] == 0) {
                right--;
            } else {
                swap(array, left++, right--);
            }
        }
        return array;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
