package com.chaoran;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chaoranli on 10/11/17.
 * reconstruct a complete binary tree from its level-order traversal sequence only.
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class LevelOrderReconstructBinaryTree {

    public TreeNode reconstruct(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrder[0]);
        q.offer(root);
        int i = 1;
        while (i < levelOrder.length) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                TreeNode cur = q.poll();
                if (i < levelOrder.length) {
                    cur.left = new TreeNode(levelOrder[i++]);
                    q.offer(cur.left);
                }
                if (i < levelOrder.length) {
                    cur.right = new TreeNode(levelOrder[i++]);
                    q.offer(cur.right);
                }
            }
        }
        return root;
    }
}
