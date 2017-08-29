package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 7/17/17.
 */
public class SubSet {

    public List<String> findSubSet(String set) {
        List<String> res = new ArrayList<>();
        if (set == null || set.isEmpty()) {
            return res;
        }

        char[] charArray = set.toCharArray();
        StringBuilder subSet = new StringBuilder();
        helper(charArray, subSet, 0, res);
        return res;
    }

    private void helper(char[] input, StringBuilder subSet, int index, List<String> res) {
        if (index == input.length) {
            res.add(subSet.toString());
            return;
        }

        helper(input, subSet.append(input[index]), index + 1, res);
        subSet.deleteCharAt(subSet.length() - 1);
        helper(input, subSet, index + 1, res);
    }

}
