package com.chaoran;

/**
 * Created by chaoranli on 3/16/18.
 * if root less than two nodes we go right
 * if root larger than two nodes we go left
 * if root in the middle of two nodes return we find it
 */
public class LowestCommonAncestorInBST {

    public TreeNode lca(TreeNode root, int p, int q) {
        // Write your solution here
        if (root == null) {
            return root;
        }

        if (root.val < p && root.val < q) {
            return lca(root.right, p, q);
        } else if (root.val > p && root.val > q) {
            return lca(root.left, p, q);
        } else {
            return root;
        }
    }
}
