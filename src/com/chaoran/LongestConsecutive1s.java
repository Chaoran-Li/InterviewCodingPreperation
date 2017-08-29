package com.chaoran;

/**
 * Created by chaoranli on 8/12/17.
 */
public class LongestConsecutive1s {

    public int longest(int[] array) {
        int longest = 0;
        int curLongest = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1) {
                curLongest = 0;
            } else {
                curLongest++;
            }
            longest = Math.max(longest, curLongest);
        }
        return longest;
    }
}
