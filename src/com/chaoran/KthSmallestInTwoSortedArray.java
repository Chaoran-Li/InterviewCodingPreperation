package com.chaoran;

/**
 * Created by chaoranli on 10/21/17.
 */
public class KthSmallestInTwoSortedArray {

    public int kth(int[] a, int[] b, int k) {
        if (a.length == 0) {
            return b[k - 1];
        }
        if (b.length == 0) {
            return a[k - 1];
        }

        int count = 1;
        int i = 0;
        int j = 0;
        while (count < k) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
                j++;
            }
            count++;
        }
        if (a[i] <= b[j]) {
            return a[i];
        } else {
            return b[j];
        }
    }
}
