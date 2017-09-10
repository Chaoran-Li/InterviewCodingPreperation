package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 9/9/17.
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class CommonNumberOfThreeSortedArrays {

    public List<Integer> findCommon(int[] a, int[] b, int[] c) {
        // assumption: arrays are not null
        // duplicate elements in each array
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> res = new ArrayList<>();
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                res.add(a[i]);
                i++;
                j++;
                k++;
            } else if (a[i] <= b[j] && a[i] <= c[k]) {
                i++;
            } else if (b[j] <= a[i] && b[j] <= c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return res;
    }
}
