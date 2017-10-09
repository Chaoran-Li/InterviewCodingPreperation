package com.chaoran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chaoranli on 10/8/17.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] array, int target) {
        // assume the array is not null and has at least 4 elements
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < array.length - 2; j++) {
                if (j > 1 && array[j] == array[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = array.length - 1;
                while (left < right) {
                    int part = array[right] + array[left];
                    if (array[i] + array[j] + part == target) {
                        res.add(Arrays.asList(array[i], array[j], array[left], array[right]));
                        left++;
                        if (left < right && array[left] == array[left - 1]) {
                            continue;
                        } else if (array[i] + array[j] + part > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
