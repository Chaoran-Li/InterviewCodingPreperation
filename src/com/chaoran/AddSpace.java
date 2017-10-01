package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 10/1/17.
 * Given a string, insert space into the middle of each pair character
 * find the all permutation of string after insertion the empty space
 * time complexity: O(2^n)
 * space complexity: O(log^n)
 */
public class AddSpace {

    public List<String> add(String input) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() <= 1) {
            return res;
        }
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(array, 0, sb, res);
        return res;
    }

    private void helper(char[] array, int index, StringBuilder sb, List<String> res) {
        if (index == array.length - 1) {
            sb.append(array[index]);
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append(array[index]);
        sb.append(" ");
        helper(array, index + 1; sb, res);
        sb.deleteCharAt(sb.length() - 1);
        helper(array, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}
