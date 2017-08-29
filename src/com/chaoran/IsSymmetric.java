package com.chaoran;

/**
 * Created by chaoranli on 6/7/17.
 * time complexity: O(n)
 * space complexity: O(log^n)
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        }

        return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
}
