package com.chaoran;

/**
 * Created by chaoranli on 3/9/17.
 * 分治法，先判断左边是不是identical，在判断右边是不是identical
 * 最后把结果合起来
 */
public class IdenticalBinaryTree {

    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.val != root2.val) {
            return false;
        }

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}
