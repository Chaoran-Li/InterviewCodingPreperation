package com.chaoran;

/**
 * Created by chaoranli on 9/3/17.
 * Find the maximum possible subpath sum
 * (both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes
 * and the subpath is allowed to contain only one node).
 */
public class MaximumPathSumIII {
    /**
     * method 1
     * up bottom
     * time complexity: O(n)
     * space complexity: O(log^n)*
     */
    public int maxPath1(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int[] globalMax = {Integer.MIN_VALUE};
        helper(root, 0, globalMax);
        return globalMax[0];

    }

    public void helper(TreeNode root, int sum, int[] globalMax) {
        if (root == null) {
            return;
        }

        sum = Math.max(sum, 0) + root.val;
        globalMax[0] = Math.max(globalMax[0], sum);

        helper(root.left, sum, globalMax);
        helper(root.right, sum, globalMax);
    }

    /**
     * method 2
     * bottom up
     */
    public int maxPath2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int[] globalMax = {Integer.MIN_VALUE};
        helper(root, globalMax);
        return globalMax[0];
    }

    private int helper(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }

        int leftSum = helper(root.left, globalMax);
        int rightSum = helper(root.right, globalMax);
        int sum = Math.max(Math.max(leftSum, rightSum), 0) + root.val;
        globalMax[0] = Math.max(sum, globalMax[0]);
        return sum;
    }
}
