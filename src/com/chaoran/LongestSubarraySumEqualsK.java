package com.chaoran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaoranli on 12/19/17.
 * Coursera OA
 * Given an array, find the longest sub array which has sum equal to k
 */
public class LongestSubarraySumEqualsK {

    public int longest(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum == k) {
                longest = Math.max(longest, i + 1);
            }

            int diff = sum - k;

            if (map.containsKey(diff)) {
                longest = Math.max(longest, i - map.get(diff));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return longest;
    }
}
