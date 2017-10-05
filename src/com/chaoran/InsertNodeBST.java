package com.chaoran;

/**
 * Created by chaoranli on 10/5/17.
 */
public class InsertNodeBST {

    public TreeNode insert(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }

        helper(root, target);
        return root;

    }

    private TreeNode helper(TreeNode cur, int target) {
        if (cur == null) {
            return new TreeNode(target);
        }
        if (cur.val == target) {
            return cur;
        }
        if (target > cur.val) {
            cur.right = helper(cur.right, target);
        } else {
            cur.left = helper(cur.left, target);
        }
        return cur;
    }
}
