package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 3/13/18.
 * Given a set of n integers
 * divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
 */
public class TwoSubsetsWithMinDiff {

    public int minDiff(int[] array) {
        if (array == null || array.length <= 1) {
            return Integer.MIN_VALUE;
        }

        List<Integer> sum = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        DFS(array, 0, subset, sum);
        return getminDiff(sum);
    }

    private void DFS(int[] array, int index, List<Integer> subset, List<Integer> sum) {
        if (array.length % 2 == 0) {
            if (index >= array.length) {
                if (subset.size() == array.length / 2) {
                    int sumup = 0;
                    for (int i = 0; i < subset.size(); i++) {
                        sumup += subset.get(i);
                    }
                    sum.add(sumup);
                }
                return;
            }
        } else {
            if (index >= array.length) {
                if (subset.size() == array.length / 2 || subset.size() == array.length / 2 + 1) {
                    int sumup = 0;
                    for (int i = 0; i < subset.size(); i++) {
                        sumup += subset.get(i);
                    }
                    sum.add(sumup);
                }
            }
            return;
        }
        subset.add(array[index]);
        DFS(array, index + 1, subset, sum);
        subset.remove(subset.size() - 1);
        DFS(array, index + 1, subset, sum);
    }

    private int getminDiff(List<Integer> sum) {
        int global = Integer.MAX_VALUE;
        for (int i = 0; i < sum.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < sum.size(); j++) {
                min = Math.min(min, Math.abs(sum.get(i) - sum.get(j)));
            }
            global = Math.min(global, min);
        }
        return global;
    }
}
