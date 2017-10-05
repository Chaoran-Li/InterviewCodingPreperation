package com.chaoran;

/**
 * Created by chaoranli on 10/5/17.
 */
public class ClosestNumberInBST {

    public int closest(TreeNode root, int target) {
        int res = root.val;
        while (root != null) {
            if (root.val == target) {
                return root.val;
            } else {
                if (Math.abs(root.val - target) < Math.abs(res - target)) {
                    res = root.val;
                }
                if (root.val < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        return res;
    }
}
