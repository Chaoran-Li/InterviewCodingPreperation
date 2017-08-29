package com.chaoran;

/**
 * Created by chaoranli on 8/5/17.
 */
public class LowestCommonAncestor {

    public TreeNode LCA(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }

        if (root == one || root == two) {
            return root;
        }
        TreeNode leftSide =LCA(root.left, one, two);
        TreeNode rightSide = LCA(root.right, one, two);
        if (leftSide != null && rightSide != null) {
            return root;
        }
        return leftSide == null ? rightSide : leftSide;
    }
}
