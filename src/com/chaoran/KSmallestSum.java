package com.chaoran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chaoranli on 7/30/17.
 */
public class KSmallestSum {

    // brute force method. It's not a good
    public int kthSmallestSum(int[] A, int[] B, int k) {
        List<Integer> sumList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = A[i] + B[j];
                sumList.add(sum);
            }
        }
        int[] res = new int[sumList.size()];
        for (int l = 0 ; l < sumList.size(); l++) {
            res[l] = sumList.get(l);
        }
        Arrays.sort(res);
        return res[k];
    }
}
