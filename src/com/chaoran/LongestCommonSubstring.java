package com.chaoran;

/**
 * Created by chaoranli on 3/31/18.
 */
public class LongestCommonSubstring {

    public String longestCommon(String s, String t) {
        if (s == null || t == null) {
            return null;
        }

        char[] arrayA = s.toCharArray();
        char[] arrayB = t.toCharArray();
        int[][] common = new int[s.length()][t.length()];
        int longest = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (arrayA[i] == arrayB[j]) {
                    if (i == 0 || j == 0) {
                        common[i][j] = 1;
                    } else {
                        common[i][j] = common[i - 1][j - 1] + 1;
                    }
                }
                if (common[i][j] > longest) {
                    longest = common[i][j];
                    end = j;
                }
            }
        }
        return t.substring(end - longest + 1, end + 1);
    }
}
