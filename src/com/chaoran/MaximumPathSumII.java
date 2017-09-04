package com.chaoran;

/**
 * Created by chaoranli on 9/3/17.
 * Find the maximum possible sum from any node to any node (the start node and the end node can be the same)
 * do not record the negative node
 * time complexity: O(n)
 * space complexity: O(log^n)
 */
public class MaximumPathSumII {

    public int maxSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int[] globalMax = {Integer.MIN_VALUE};
        helper(root, globalMax);
        return globalMax[0];

    }

    public int helper(TreeNode root, int[] globalMax) {
        if (root == null) {
            return 0;
        }

        int leftSum = helper(root.left, globalMax);
        int rightSum = helper(root.right, globalMax);

        leftSum = leftSum > 0 ? leftSum : 0;
        rightSum = rightSum > 0 ? rightSum : 0;

        globalMax[0] = Math.max(globalMax[0], leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
