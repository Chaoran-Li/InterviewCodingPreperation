package com.chaoran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chaoranli on 12/19/17.
 * Coursera OA
 * Given a string, find all sub string are palindrome
 */
public class AllPalindrome {

    public int findAllPalindrome(String input) {
        int len = input.length();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < (len - i); j++) {
                String subString = input.substring(j, i + j + 1);
                if (isPalin(subString)) {
                    res.add(subString);
                }
            }
        }
        return res.size();
    }

    private boolean isPalin(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
