package com.chaoran;

/**
 * Created by chaoranli on 8/6/17.
 */
public class LongestAscendingSubArray {

    public int longest(int[] array) {
        //assume array != null
        if (array.length == 0) {
            return 0;
        }

        int result = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                cur++;
                result = Math.max(cur, result);
            } else {
                cur = 1;
            }
        }
        return result;
    }
}
