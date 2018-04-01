package com.chaoran;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chaoranli on 3/21/18.
 * Given a Binary Tree, return the right view of it.
 * Right view of a Binary Tree is list of nodes visible when tree is visited from Right side,
 * the order of the nodes in the list should be from top to bottom level of the original tree.
 * use BFS traverse whole tree, for every node, put the right node first and then left node
 * for each level, put the first node poll from queue into res
 * time complexity: O(n);
 * space complexity: O(n);
 */
public class RightViewOfBinaryTree {

    public List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == 0) {
                    res.add(cur.val);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }
        }
        return res;
    }
}
