package com.chaoran;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chaoranli on 10/11/17.
 * Given a binary Tree and the two keys, determine whether the two nodes are cousins of each other or not.
 * Two nodes are cousins of each other if they are at the same level and have different parents.
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int a, int b) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> layer = new LinkedList<>();
        TreeNode parentA = null;
        TreeNode parentB = null;
        layer.offer(root);

        while (!layer.isEmpty()) {
            int size = layer.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = layer.poll();
                if (cur.left != null) {
                    if (cur.left.val == a) {
                        parentA = cur;
                    } else if (cur.left.val == b) {
                        parentB = cur;
                    }
                    layer.offer(cur.left);
                }

                if (cur.right != null) {
                    if (cur.right.val == a) {
                        parentA = cur;
                    } else if (cur.right.val == b) {
                        parentB = cur;
                    }
                    layer.offer(cur.right);
                }
            }

            if (parentA != null && parentB != null) {
                return parentA != parentB;
            } else if (parentA != null || parentB != null) {
                return false;
            }
        }
        return false;
    }
}
