package com.chaoran;

import java.util.*;

/**
 * Created by chaoranli on 9/10/17.
 * Given a set of characters with duplicated represented by a String,
 * return a list containing all subsets of the characters.
 */
public class SubsetII {

    public List<String> findSubset(String set) {
        List<String> res = new ArrayList<>();
        if (set == null || set.length() == 0) {
            return res;
        }

        char[] input = set.toCharArray();
        Arrays.sort(input);
        StringBuilder subset = new StringBuilder();
        helper(input, subset, 0, res);
        return res;
    }

    public void helper(char[] input, StringBuilder subset, int index, List<String> res) {
        if (index == input.length) {
            res.add(subset.toString());
            return;
        }
        helper(input, subset.append(input[index]), index + 1, res);
        subset.deleteCharAt(subset.length() - 1);
        // skip duplicate characters
        while (index < input.length - 1 && input[index + 1] == input[index]) {
            index++;
        }
        helper(input, subset, index + 1, res);
    }
}
