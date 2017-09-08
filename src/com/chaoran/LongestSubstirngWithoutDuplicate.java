package com.chaoran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chaoranli on 9/7/17.
 */
public class LongestSubstirngWithoutDuplicate {

    public int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        if (input.length() == 1) {
            return 1;
        }

        int slow = 0;
        int fast = 0;
        int longest = 0;
        Set<Character> set = new HashSet<>();
        while (fast < input.length()) {
            if (set.contains(input.charAt(fast))) {
                set.remove(input.charAt(slow++));
            } else {
                set.add(input.charAt(fast++));
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }
}
