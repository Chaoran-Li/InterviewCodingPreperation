package com.chaoran;

import java.util.HashSet;

/**
 * Created by chaoranli on 7/28/17.
 */
public class MissingNumber {

    public int findNumberUsingHashset(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : array) {
            set.add(number);
        }

        int i = 1;
        while (i < array.length + 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    public int sumUpFindNumber(int[] array) {
        long missingNumberSum = 0L;
        int n = array.length + 1;
        long targetSum = n * (1 + n) / 2;
        for (int number : array) {
            missingNumberSum += array[number];
        }
        return (int) (targetSum - missingNumberSum);
    }

}
