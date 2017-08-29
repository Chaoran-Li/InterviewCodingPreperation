package com.chaoran;

/**
 * Created by chaoranli on 3/6/17.
 */
public class MaxDepthOfBinaryTree {
    int depth = 0;

    public int maxDepth(TreeNode root) {
        helper(root,1);
        return depth;
    }

    public void helper(TreeNode root, int curDepth) {
        if(root == null) {
            return;
        }

        if(curDepth > depth) {
            depth = curDepth;
        }

        helper(root.left,curDepth + 1);
        helper(root.right,curDepth + 1);
    }
}
