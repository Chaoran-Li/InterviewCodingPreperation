package com.chaoran;

/**
 * Created by chaoranli on 3/9/17.
 */
public class InvertBinaryTree {

    public void invert(TreeNode root) {
        if(root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
}
