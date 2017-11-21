package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 7/27/17.
 * time complexity: O(target^coins)
 * space complexity: O(coins)
 */
public class CombinationsOfCoins {

    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(target, coins, 0, cur, res);
        return res;
    }

    private void helper(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> res) {
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }

        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            helper(target - i * coins[index], coins, index + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
