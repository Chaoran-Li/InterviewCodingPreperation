package com.chaoran;

/**
 * Created by chaoranli on 9/9/17.
 * time compleixty: O(log^n)
 * space complexity: O(log^n)
 */
public class ReverseBinaryTreeUpsideDown {

    public TreeNode reverseUpsideDown(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = reverseUpsideDown(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
