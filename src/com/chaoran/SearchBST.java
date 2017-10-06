package com.chaoran;

/**
 * Created by chaoranli on 10/5/17.
 */
public class SearchBST {

    public TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key == root.val) {
            return root;
        } else if (key > root.val) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }
}
