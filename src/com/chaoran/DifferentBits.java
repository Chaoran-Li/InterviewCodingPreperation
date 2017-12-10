package com.chaoran;

/**
 * Created by chaoranli on 12/9/17.
 */
public class DifferentBits {

    public int diffBits(int a, int b) {
        return oneCounter(a ^ b);
    }

    private int oneCounter(int n) {
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            counter += n & 1;
            n >>= 1;
        }
        return counter;
    }
}
