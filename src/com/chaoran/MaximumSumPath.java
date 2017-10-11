package com.chaoran;

/**
 * Created by chaoranli on 10/10/17.
 * find the path has the maximum sum
 * time complexity: O(n)
 * space complexity: O(log^n)
 */
public class MaximumSumPath {

    public int maximumSumPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] globalMax = new int[] {Integer.MIN_VALUE};
        helper(root, globalMax, 0);
        return globalMax[0];
    }

    private void helper(TreeNode root, int[] globalMax, int curMax) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            globalMax[0] = Math.max(globalMax[0], curMax + root.val);
            return;
        }
        helper(root.left, globalMax, curMax + root.val);
        helper(root.right, globalMax, curMax + root.val);
    }
}
