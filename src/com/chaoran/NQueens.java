package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 8/10/17.
 */
public class NQueens {
    // assume n > 0
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, res);
        return res;
    }

    private void helper(int n, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == n) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> cur, int column) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }
}
