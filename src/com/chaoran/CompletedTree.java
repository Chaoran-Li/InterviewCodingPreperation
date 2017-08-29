package com.chaoran;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chaoranli on 7/16/17.
 */
public class CompletedTree {

    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            //same logical for left node
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                q.offer(cur.left);
            }
            //same logical for right node
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                q.offer(cur.right);
            }
        }
        return true;
    }
}
