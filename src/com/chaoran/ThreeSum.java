package com.chaoran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chaoranli on 10/8/17.
 * Determine if there exists three elements in a given array that sum to the given target number.
 * Return all the triple of values that sums to target. No duplicate triples should be returned.
 * time complexity: O(n^2)
 * space complexity: O(1)
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] array, int target) {
        // assume the array is not null and has at least 3 elements
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            // ignore duplicate i
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int part = array[left] + array[right];
                if (array[i] + part == target) {
                    res.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    // ingnore duplicate left
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (array[i] + part > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
