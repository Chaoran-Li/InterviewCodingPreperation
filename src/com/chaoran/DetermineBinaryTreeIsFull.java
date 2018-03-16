package com.chaoran;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chaoranli on 3/15/18.
 */
public class DetermineBinaryTreeIsFull {

    public boolean isFull(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null && cur.right != null) {
                    q.offer(cur.left);
                    q.offer(cur.right);
                } else if (cur.left != null || cur.right != null) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }
}
