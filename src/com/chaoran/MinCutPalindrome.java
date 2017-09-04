package com.chaoran;

/**
 * Created by chaoranli on 8/29/17.
 */
public class MinCutPalindrome {

    public int minCut(String input) {
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
                } else if (isPali(input, j + 1, i)) {
                    curMin[i] = Math.min(curMin[i], curMin[j] + 1);
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
            start++;
            end--;
        }
        return true;
    }

}
