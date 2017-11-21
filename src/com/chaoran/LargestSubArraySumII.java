package com.chaoran;

/**
 * Created by chaoranli on 9/29/17.
 * need return the start and end index for the longest sum array
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class LargestSubArraySumII {

    public int[] largestSum(int[] array) {
        if (array == null) {
            return null;
        }

        int[] res = new int[3];
        int largest = Integer.MIN_VALUE;
        int curSum = array[0];
        int curStart = 0;
        int solStart = 0;
        int solEnd = 0;

        for (int i = 1; i < array.length; i++) {
            if (curSum >= 0) {
                curSum = curSum + array[i];
            } else {
                curSum = array[i];
                curStart = i;
            }

            largest = Math.max(largest, curSum);

            if (largest < curSum) {
                solStart = curStart;
                solEnd = i;
            }
        }
        res[0] = solStart;
        res[1] = solEnd;
        res[2] = largest;
        return res;
    }
}
