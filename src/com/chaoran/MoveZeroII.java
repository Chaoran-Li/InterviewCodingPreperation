package com.chaoran;

/**
 * Created by chaoranli on 9/12/17.
 * the positions should be maintain
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class MoveZeroII {

    public int[] moveZero(int[] array) {
        int slow =0;
        int fast = 0;
        while (array[fast] < array.length) {
            if (fast != 0) {
                array[slow++] = array[fast++];
            } else {
                fast++;
            }
        }

        while (slow < array.length) {
            array[slow++] = 0;
        }
        return array;
    }
}
