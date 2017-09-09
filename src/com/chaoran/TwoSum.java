package com.chaoran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chaoranli on 9/8/17.
 * time complexity: O(n)
 * space compelxity: O(n)
 */
public class TwoSum {

    public boolean twoSum(int[] array, int target) {
        if (array == null || array.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
