package com.chaoran;

/**
 * Created by chaoranli on 10/15/17.
 * Pure Storage OA #7
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class PalindromSubStrs {
    int count;

    public int countPalin(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            isPalin(s, i, i); // odd length;
            isPalin(s, i, i + 1); // even length
        }

        return count;
    }

    private void isPalin(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
