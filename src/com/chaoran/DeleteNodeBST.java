package com.chaoran;

/**
 * Created by chaoranli on 10/6/17.
 */
public class DeleteNodeBST {

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = delete(root.left, key);
        } else if (root.val < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                TreeNode smallest = findSmall(root.right);
                root.val = smallest.val;
                root.right = delete(root.right, smallest.val);
            }
        }
        return root;
    }

    private TreeNode findSmall(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        TreeNode small = findSmall(node.left);
        return small;
    }
}
