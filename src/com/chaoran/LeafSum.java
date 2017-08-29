package com.chaoran;

/**
 * Created by chaoranli on 3/5/17.
 */
public class LeafSum {

    public int sum(TreeNode root) {
        int sum = 0;
        if(root == null) {
            return 0;
        }

        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int sum) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            sum = sum + root.val;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }
}
