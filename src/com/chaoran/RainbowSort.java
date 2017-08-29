package com.chaoran;

/**
 * Created by chaoranli on 6/15/17.
 */
public class RainbowSort {

    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int i= 0;
        int j = 0;
        int k = arr.length - 1;

        while (j <= k) {
            if (arr[j] == -1) {
                swap(arr, i++, j++);
            } else if (arr[j] == 0) {
                j++;
            } else {
                swap(arr, j, k--);
            }
        }
        return arr;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
