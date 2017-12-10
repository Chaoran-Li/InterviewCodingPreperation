package com.chaoran;

/**
 * Created by chaoranli on 12/9/17.
 */
public class IsPowerOfTwo {

    public boolean check(int n) {
        return n > 0 && oneCounter(n) == 1;
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
