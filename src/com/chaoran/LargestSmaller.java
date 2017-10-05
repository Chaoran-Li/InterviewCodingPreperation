package com.chaoran;

/**
 * Created by chaoranli on 10/5/17.
 */
public class LargestSmaller {

    public int largestSmaller(TreeNode root, int target) {
        int res = Integer.MIN_VALUE;
        while (root != null) {
            if (root.val < target) {
                if (Math.abs(root.val - target) < Math.abs(res - target)) {
                    res = root.val;
                }
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }
}
