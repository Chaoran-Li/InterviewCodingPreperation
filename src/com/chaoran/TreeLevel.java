package com.chaoran;

/**
 * Created by chaoranli on 3/5/17.
 */
public class TreeLevel {

    public int sumOfLevel(TreeNode root, int target) {
       int sum = 0;

        if(root == null) {
            return 0;
        }

        helper(root, target,0, 1);
        return sum;

    }

    public void helper(TreeNode root, int target, int sum, int depth) {
        if(root == null) {
            return;
        }


        if(depth == target) {
            sum = sum + root.val;
        }

        helper(root.left, target, sum, depth + 1);
        helper(root.right, target, sum, depth + 1);
    }
}
