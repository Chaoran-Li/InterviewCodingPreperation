package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 7/17/17.
 * given a String with out duplicate character, find all subset of the String
 * time complexity: O(2^n)
 * space complexity: O(n)
 */
public class SubSetI {

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

    public List<String> subSet(String input) {
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        DFS(array, 0, sb, res);
        return res;
    }

    private void DFS(char[] array, int index, StringBuilder sb, List<String> res) {
        res.add(sb.toString());
        for (int i = index; i < array.length; i++) {
            sb.append(array[i]);
            DFS(array, i + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
