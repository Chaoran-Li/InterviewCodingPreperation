package com.chaoran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaoranli on 11/16/17.
 * Given two integer arrays A1 and A2, sort A1 in such a way that the relative order among the elements will be same as those are in A2.
 * For the elements that are not in A2, append them in the right end of the A1 in an ascending order.
 */
public class SortInSpecifiedOrder {
    // assumption: A1 and A2 are not null
    // no duplication in A2
    public int[] sortSpecial(int[] A1, int[] A2) {
        Integer[] intergerArray = toIntegerArray(A1);
        Arrays.sort(intergerArray, new MyComparator(A2));
        toIntArray(intergerArray, A1);
        return A1;
    }

    private Integer[] toIntegerArray(int[] array) {
        Integer[] res = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
        return res;
    }

    private void toIntArray(Integer[] array, int[] res) {
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
    }

    static class MyComparator implements Comparator<Integer> {
        private Map<Integer, Integer> map;

        public MyComparator(int[] array) {
            map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                map.put(array[i], i);
            }
        }

        @Override
        public int compare(Integer one, Integer two) {
            Integer indexOne = map.get(one);
            Integer indexTwo = map.get(two);

            if (indexOne != null && indexTwo != null) {
                return indexOne.compareTo(indexTwo);
            } else if (indexOne == null && indexTwo == null) {
                return one.compareTo(two);
            }
            return indexOne != null ? -1 : 1;
        }
    }
}
