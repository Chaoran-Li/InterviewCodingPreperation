package com.chaoran;

import java.util.Arrays;

/**
 * Created by chaoranli on 8/21/17.
 */
public class ArrayDeduplication {
    /**
     * keep one of duplicate
     * assume the array is not null
     * the left part of the slow(include the slow pointer) is result
     * the right part of fast pointer is unexplore area
     * the part between slow and fast is what we don't want
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int[] dedupI(int[] array) {

        if (array.length <= 0) {
            return array;
        }

        int slow = 0; // the first one must be return
        int fast = 1;
        while (fast < array.length) {
            if (array[fast] == array[slow]) {
                fast++;
            } else {
                array[++slow] = array[fast++];
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }

    /**
     * keep at most two elements of duplicate group
     * assume the array is not null
     * the left part of slow pointer(not including slow pointer) is result
     * time complexity: O(n)
     * space complexity: O(1)
     */

    public int[] dedupII(int[] array) {

        if (array.length <= 2) {
            return array; // if the two elements are same, we just return it anyway
        }

        int slow = 2;
        int fast = 2;
        while (fast < array.length) {
            if (array[fast] == array[slow - 2]) {
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        }
        return Arrays.copyOf(array, slow);
    }

    /**
     * don't keep any element of duplicate group
     * the left part of slow pointer(including slow pointer) is result
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int[] dedupIII(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int slow = 0;
        int fast = 1;
        boolean flag = false; // use flag to check if array[slow] is duplicate
        while (fast < array.length) {
            // if array[fast] is duplicate, set the flag to true
            if (array[fast] == array[slow]) {
                fast++;
                flag = true;
            } else if (flag == true) {
                /**
                 * if array[fast] != array[slow] and the flag is set
                 * array[slow] is not valid element, replace array[slow] = array[fast]
                 * continue check if there is duplicate for array[fast]
                 * reset the flag to false
                 * */
                array[slow] = array[fast++];
                flag = false;
            } else {
                // if array[slow] != array[fast] and the flag is not set
                // array[fast] should be valid element
                array[++slow] = array[fast++];
            }
        }
        return Arrays.copyOf(array, flag ? slow : slow + 1);
    }

    /**
     * Given an unsorted integer array, remove adjacent duplicate elements repeatedly,
     * from left to right. For each group of elements with the same value do not keep any of them.
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int[] dedupIV(int[] array) {
        // Write your solution here.
        if (array.length <= 1) {
            return array;
        }

        int end = 0;
        for (int i = 1; i < array.length; i++) {
            if (end == -1 || array[i] != array[end]) {
                array[++end] = array[i];
            } else {
                end--;
                while (i + 1 < array.length && array[i] == array[i + 1]) {
                    i++;
                }
            }
        }
        return Arrays.copyOf(array, end + 1);
    }


}
