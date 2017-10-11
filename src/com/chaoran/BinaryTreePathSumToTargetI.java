package com.chaoran;

/**
 * Created by chaoranli on 10/10/17.
 * if exist a path(root to leaf), sum of path equal to target
 */
public class BinaryTreePathSumToTargetI {

    public boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return target == root.val;
        }

        return exist(root.left, target - root.val) || exist(root.right, target - root.val);
    }
}
