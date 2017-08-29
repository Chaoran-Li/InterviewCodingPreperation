package com.chaoran;

/**
 * Created by chaoranli on 8/18/17.
 */
public class PerfectShuffle {

    public void shuffle(int[] array) {
        // assume the array is not null
        if (array.length <= 1) {
            return;
        }

        for (int i = array.length; i >= 1; i--) {
            int idx = (int) (Math.random() * i);
            swap(array, i - 1, idx);
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
