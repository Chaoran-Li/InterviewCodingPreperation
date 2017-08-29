package com.chaoran;

import java.util.Map;

/**
 * Created by chaoranli on 8/6/17.
 */
public class MaxProductOfCuttingRope {

    public int maxProduct(int length) {
        //assumption length >= 2
        if (length == 2) {
            return 1;
        }

        int[] array = new int[length + 1];
        array[1] = 0;
        array[2] = 1;

        for (int i = 3; i < array.length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                array[i] = Math.max(array[i], j * Math.max(i - j, array[i - j]));
            }
        }
        return array[length];
    }

    public int maxProductI(int length) {
        if (length == 2) {
            return 1;
        }
        int[] array = new int[length + 1];
        array[1] = 1;
        array[2] = 1;
        for (int i = 3; i < array.length; i++) {
                int curMax = 0;
            for (int j = 1; j <= i / 2; j++) {
                curMax = Math.max(curMax, Math.max(j, array[j]) * Math.max(i - j, array[i - j]));
            }
            array[i] = curMax;
        }
        return array[length];
    }
}
