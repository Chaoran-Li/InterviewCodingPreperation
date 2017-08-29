package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 7/1/17.
 */
public class PrintBSTInGivenRange {

    public List<Integer> print(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        printHelper(root, min, max, res);
        return res;

    }

    private void printHelper(TreeNode root, int min, int max, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.val > min) {
            printHelper(root.left, min, max, res);
        }

        if (root.val >= min && root.val <= max) {
            res.add(root.val);
        }

        if (root.val < max) {
            printHelper(root.right, min, max, res);
        }
    }
}
