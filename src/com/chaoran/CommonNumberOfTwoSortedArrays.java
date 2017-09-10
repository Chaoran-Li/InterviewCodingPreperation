package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 7/28/17.
 */
public class CommonNumberOfTwoSortedArrays {

    public List<Integer> findCommonNumber(List<Integer> s1, List<Integer> s2) {
         List<Integer> commons = new ArrayList<>();
         int i = 0;
         int j = 0;
         while (i < s1.size() && j < s2.size()) {
             if (s1.get(i) == s2.get(j)) {
                 commons.add(s1.get(i));
                 i++;
                 j++;
             } else if (s1.get(i) < s2.get(j)) {
                 i++;
             } else {
                 j++;
             }
         }
         return commons;
    }
}
