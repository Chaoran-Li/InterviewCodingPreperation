package com.chaoran;

/**
 * Created by chaoranli on 1/21/18.
 */
public class ChartoInt {
    /**
     * @param input
     * @return
     * assume string only contain number
     * the number of the string represented is positive integer number
     * within the integer range
     */

    public int parseInt(String input) {
        if (input == null) {
            return Integer.MIN_VALUE;
        }

        int res = 0;
        for (char c : input.toCharArray()) {
            res = res * 10 + (c - '0');
        }
        return res;
    }
}
