package com.chaoran;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chaoranli on 3/11/18.
 */
public class IterativeTraverseBinaryTree {
    /**
     * using a stack data structure to simulate the recursive stack frame
     * for every node, put the right child first and then put the left child
     */
    public List<Integer> preOrderIterative(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            res.add(cur.val);
            if (cur.right != null) {
                stack.offerLast(cur.right);
            }
            if (cur.left != null) {
                stack.offerLast(cur.left);
            }
        }
        return res;
    }

    /**
     * for every node, push left subtree into stack
     * back-tracking to right subtree
     */
    public List<Integer> inorderIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            res.add(cur.val);
            cur = cur.right;
            pushLeft(cur, stack);
        }
        return res;
    }

    private void pushLeft(TreeNode cur, Deque<TreeNode> stack) {
        while (cur != null) {
            stack.offerLast(cur);
            cur = cur.left;
        }
    }
}
