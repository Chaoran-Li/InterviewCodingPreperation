package com.chaoran;

/**
 * Created by chaoranli on 6/7/17.
 * time complexity: O(n) traverse every node
 * space complexity: O(log^n) height of tree
 * for every node, the value of the left child should be smaller than the root
 * the value of the right child should be bigger than the root
 */
public class IsBST {

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return isBSTHelper(root, min, max);
    }

    public boolean isBSTHelper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isBSTHelper(root.left, min, root.val) && isBSTHelper(root.right, root.val, max);
    }
}
