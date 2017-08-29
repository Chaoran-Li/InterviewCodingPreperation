package com.chaoran;

import java.util.HashMap;
import java.util.Map;

/**
*hashmap不允许出现重复的值
*利用hashmap这个特性，可以去除数组中重复的值
*
*
*
*/
public class RemoveDuplicateNumber {

    public static int deduplicate(int[] nums3) {
        HashMap<Integer, Boolean> nums = new HashMap<>();
        for(int i = 0; i < nums3.length; i++) {
            nums.put(nums3[i], true);
        }

        int result = 0;
        for (Map.Entry<Integer, Boolean> entry : nums.entrySet()) {
            nums3[result++] = entry.getKey();
        }
        return result;

    }
}
