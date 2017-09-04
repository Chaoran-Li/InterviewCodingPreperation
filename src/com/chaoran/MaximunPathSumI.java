package com.chaoran;

/**
 * Created by chaoranli on 9/3/17.
 * find the maximum path for binary tree(from leaf node to another leaf node)
 * time complexity: O(n)
 * space complexity: O(log^n)
 */
public class MaximunPathSumI {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int[] globalMax = {Integer.MAX_VALUE};
        return helper(root, globalMax);
    }

    private int helper(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }

        int leftSum = helper(root.left, globalMax);
        int rightSum = helper(root.right, globalMax);

        if (root.left != null && root.right != null) {
            globalMax[0] = Math.max(globalMax[0], leftSum + rightSum + root.val);
            return Math.max(leftSum + root.val, rightSum + root.val);
        } else {
            return root.left == null ? rightSum + root.val : leftSum + root.val;
        }
    }

}
