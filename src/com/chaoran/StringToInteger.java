package com.chaoran;

/**
 * Created by chaoranli on 2/21/17.
 * String to Integer
 */
public class StringToInteger {

    public static int convert(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        boolean negative = str.charAt(0) == '-';
        int start = negative ? 1 : 0;

        int result = 0;
        for (int i = start; i < str.length(); ++i) {
            char ch = str.charAt(i);
            int digit = ch - '0';

            if (!negative) {
                int tmp = result * 10 + digit;
                if (!(tmp / 10 == result && tmp % 10 == digit)) {
                    return Integer.MAX_VALUE;
                }
                result = tmp;
            } else {
                int tmp = result * 10 - digit;
                if (!(tmp / 10 == result && tmp % 10 == -digit)) {
                    return Integer.MIN_VALUE;
                }
                result = tmp;
            }
        }
        return result;
    }
}
