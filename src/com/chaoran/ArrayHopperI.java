package com.chaoran;

/**
 * Created by chaoranli on 8/7/17.
 * time complexity: more precise is O(n * k);
 * space complexity: O(n)
 */
public class ArrayHopperI {

    public boolean canJump(int[] array) {
        if (array.length == 1) {
            return true;
        }

        boolean[] canJump = new boolean[array.length];
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                canJump[i] = true;
            } else {
                for (int j = array[i]; j >= 1; j--) {
                    if (canJump[j + i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }
}
