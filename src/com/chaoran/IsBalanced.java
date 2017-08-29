package com.chaoran;

/**
 * Created by chaoranli on 6/7/17.
 * time complexity: O(nlog^n)
 * space complexity: O(log^n)
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
