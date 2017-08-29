package com.chaoran;

/**
 * Created by chaoranli on 5/22/17.
 */
public class Fibonacci {

    public long fibonacci(int k) {
        if (k <= 1) {
            return k;
        }

        return fibonacci(k - 1) + fibonacci(k - 2);
    }

    public long fibByDP(int k) {
        int[] fibArray = new int[k + 1];

        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 0; i <= k; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray[k];
    }
}
