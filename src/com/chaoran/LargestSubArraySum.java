package com.chaoran;

/**
 * Created by chaoranli on 8/12/17.
 */
public class LargestSubArraySum {

    public int largestSum(int[] input) {
        int max = input[0];
        int curMax = input[0];

        for (int i = 1; i < input.length; i++) {
            if (curMax < 0) {
                curMax = input[i];
            } else {
                curMax += input[i];
            }
            max = Math.max(max, curMax);
        }
        return max;
    }
}
