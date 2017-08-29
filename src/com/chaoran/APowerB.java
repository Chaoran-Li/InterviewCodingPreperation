package com.chaoran;

/**
 * Created by chaoranli on 5/23/17.
 */
public class APowerB {

    public double aPowerB(int a, int b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("no meaning");
            } else {
                return 0;
            }
        }
        if (b < 0) {
            return 1 / (double) powerHelper(a, -b);
        } else {
            return powerHelper(a, b);
        }
    }

    private long powerHelper(int a, int b) {
        if (b == 0) {
            return 1;
        }

        long half = powerHelper(a, b / 2);
        return b % 2 == 0 ? half * half : half * half * a;
    }
}
