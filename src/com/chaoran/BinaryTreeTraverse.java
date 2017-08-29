package com.chaoran;

/**
 * Created by chaoranli on 3/4/17.
 */
public class BinaryTreeTraverse {

    public static void preorderTraverse(TreeNode root) {
        // end case
        // base case
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    public static void inorderTraverse(TreeNode root) {
        // end case
        // base case
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);
        System.out.println(root.val);
        inorderTraverse(root.right);
    }

    public static void postorderTraverse(TreeNode root) {
        // end case
        // base case
        if (root == null) {
            return;
        }

        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.println(root.val);
    }




}
