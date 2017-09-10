package com.chaoran;

import java.util.*;

/**
 * Created by chaoranli on 9/8/17.
 */
public class TwoSumAllPairs {
    /**
     * Find all pairs of elements in a given array that sum to the given target number.
     * Return all the pairs of indices.
     *
     */
    public List<List<Integer>> twoSumAllPairsI(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (array == null || array.length <= 1) {
            return res;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null) {
                for (int j : indices) {
                    res.add(Arrays.asList(j, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }

    /**
     * Find all pairs of elements in a given array that sum to the pair the given target number.
     * Return all the distinct pairs of values.
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public List<List<Integer>> twoSumAllPairII(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (array == null || array.length <= 1) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> deDup = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int diff = target - array[i];
            if (map.containsKey(diff) && !deDup.contains(diff) && !deDup.contains(array[i])) {
                List<Integer> pair = new ArrayList<>();
                pair.add(diff);
                pair.add(array[i]);
                res.add(pair);
                deDup.add(diff);
                deDup.add(array[i]);
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], i);
            }
        }
        return res;
    }
}
