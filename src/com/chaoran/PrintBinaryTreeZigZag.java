package com.chaoran;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by chaoranli on 9/12/17.
 */
public class PrintBinaryTreeZigZag {

    public List<Integer> zigZag(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        int layer = 0;
        deque.offerFirst(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (layer == 0) {
                    TreeNode cur = deque.pollLast();
                    res.add(cur.val);
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                } else {
                    TreeNode cur = deque.pollFirst();
                    res.add(cur.val);
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return res;
    }
}
