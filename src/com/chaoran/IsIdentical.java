package com.chaoran;

/**
 * Created by chaoranli on 6/7/17.
 * time complexity: O(n^2)
 * 
 * space complexity: O(log^n)
 */
public class IsIdentical {

    public boolean isIdentical(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isIdentical(root.left, root.right);
    }

    private boolean isIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.val != two.val) {
            return false;
        }

        return isIdentical(one.left, two.left) && isIdentical(one.right, two.right)
                || isIdentical(one.left, two.right) && isIdentical(one.right, two.left);
    }
}
