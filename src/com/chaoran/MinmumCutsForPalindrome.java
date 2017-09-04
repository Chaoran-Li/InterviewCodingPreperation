package com.chaoran;

/**
 * Created by chaoranli on 9/3/17.
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
 * Determine the fewest cuts needed for a palindrome partitioning of a given string.
 */
public class MinmumCutsForPalindrome {
    /**
     * method 1
     * time complexity: O(n^3)
     * space complexity: O(n)
     */
    public int minCuts1(String input) {
        if (input == null || input.length() <= 1) {
            return 0;
        }

        int len = input.length();
        int[] curMin = new int[len];
        curMin[0] = 0;

        for (int i = 1; i < len; i++) {
            curMin[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPali(input, 0, i)) {
                    curMin[i] = 0;
                    continue;
                } else {
                    if (isPali(input, j + 1, i)) {
                        curMin[i] = Math.min(curMin[i], curMin[j] + 1);
                    }
                }
            }
        }
        return curMin[len - 1];

    }

    private boolean isPali(String input, int start, int end) {
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    /**
     * method 2
     * use a 2D array to record if the partition is palindrome
     * time complexity: O(n^2)
     * space complexity: O(n^2)
     */
    public int minCuts2(String input) {
        if (input == null || input.length() <= 1) {
            return 0;
        }

        char[] array = input.toCharArray();
        int len = input.length();
        boolean[][] isPali = new boolean[len + 1][len + 1];
        int[] curMin = new int[len + 1];

        for (int end = 1; end <= len; end++) {
            curMin[end] = end;
            for (int start = end; start >= 1; start--) {
                if (array[start - 1] == array[end - 1]) {
                    isPali[start][end] = end - start < 2 || isPali[start + 1][end - 1];
                }
                if (isPali[start][end]) {
                    curMin[end] = Math.min(curMin[end], curMin[start - 1] + 1);
                }
            }
        }
        return curMin[len] - 1;
    }
}
