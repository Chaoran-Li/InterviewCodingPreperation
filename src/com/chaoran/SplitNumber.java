package com.chaoran;

/**
 * Created by chaoranli on 9/28/17.
 * split number into minimum number of items such that each item is equal to an integer's square value
 * time complexity: O(n^2) --> O(1.5n)
 * space complexity: O(n)
 */
public class SplitNumber {

    public int split(int number) {
        if (number <= 0) {
            return 0;
        }

        int[] minCut = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            minCut[i] = i;
            for (int j = 1; j * j <= i; j++) {
                minCut[i] = Math.max(minCut[i], minCut[i - j * j] + 1);
            }
        }
        return minCut[number];
    }
}
