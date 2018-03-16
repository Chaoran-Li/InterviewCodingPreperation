package com.chaoran;

import java.util.ArrayList;

/**
 * Created by chaoranli on 3/13/18.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * time complexity: O(2^n)
 * space complexity: O(n)
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n == 0 && k == 0) {
            return null;
        }
        if (n == 0) {
            return null;
        }

        ArrayList<Integer> curRes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(n, k, 1, curRes, res);
        return res;
    }

    private void helper(int n, int k, int curN,
                        ArrayList<Integer> curRes,
                        ArrayList<ArrayList<Integer>> res) {
        if (curN > n) {
            if (curRes.size() == k) {
                res.add(new ArrayList<Integer>(curRes));
            }
            return;
        }
        curRes.add(curN);
        helper(n, k, curN + 1, curRes, res);
        curRes.remove(curRes.size() - 1);
        helper(n, k, curN + 1, curRes, res);
    }
}
