package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 7/18/17.
 */
public class ValidPermutationsOfParenthesis {

    public List<String> validParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder permutation = new StringBuilder();
        helper(n, 0, 0, res, permutation);
        return res;
    }

    private void helper(int pair, int left, int right, List<String> res, StringBuilder permutation) {
        if (left == pair && right == pair) {
            res.add(permutation.toString());
            return;
        }

        if (left < pair) {
            helper(pair, left + 1, right, res, permutation.append("("));
            permutation.deleteCharAt(left + right);
        }

        if (left > right) {
            helper(pair, left, right + 1, res, permutation.append(")"));
            permutation.deleteCharAt(left + right);
        }

    }
}
