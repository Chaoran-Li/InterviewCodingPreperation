package com.chaoran;

/**
 * Created by chaoranli on 6/7/17.
 */
public class TreeHeight {

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
