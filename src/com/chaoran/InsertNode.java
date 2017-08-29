package com.chaoran;

/**
 * Created by chaoranli on 3/9/17.
 */
public class InsertNode {

    public TreeNode insert(TreeNode root, TreeNode node) {
        if(root == null) {
            return node;
        }

        if(node.val < root.val) {
            root.left = insert(root.left, node);
        }

        if(node.val > root.val) {
            root.right = insert(root.right, node);
        }

        return root;
    }
}
