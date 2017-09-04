package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 9/2/17.
 */
public class ValidBlocks {

    public void validBlocks(int n) {
        List<String> blocks = new ArrayList<>();
        helper(n, 0, 0, blocks);
    }

    private void helper(int pair, int left, int right, List<String> blocks) {
        if (left == pair && right == pair) {
            print(blocks);
            return;
        }
        StringBuilder sb = new StringBuilder();

        if (left < pair) {
            for (int i = left; left > 0; left--) {
                sb.append("  ");
            }
            blocks.add(sb.append("if {").toString());
            helper(pair, left + 1, right, blocks);
            blocks.remove(blocks.size() - 1);
        }

        if (right < left) {
            for (int i = 0; i < left - right; i++) {
                sb.append("  ");
            }
            blocks.add(sb.append("}").toString());
            helper(pair, left, right + 1, blocks);
            blocks.remove(blocks.size() - 1);
        }
    }

    private void print(List<String> blocks) {
        for (String s : blocks) {
            System.out.println(s);
        }
        System.out.println("===============");
    }

}
