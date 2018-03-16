package com.chaoran;

/**
 * Created by chaoranli on 3/13/18.
 * first find the largest node in BST
 * find largest node smaller:
 * case 1: if the left child of largest node is null, return left child
 * case 2: else return the parent of the largest node
 */
public class SecondLargestNodeInBST {

    public TreeNode findSecond(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return root.left;
        }

        while (root.right.right != null) {
            root = root.right;
        }
        if (root.right.left != null) {
            return root.right.left;
        } else {
            return root;
        }
    }
}
