package com.chaoran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaoranli on 10/13/17.
 * Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class ReconstructBinaryTreeWithPreorderAndInorder {

    public TreeNode reconstruct(int[] in, int[] pre) {
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inIndex.put(in[i], i);
        }
        return helper(pre, inIndex, 0, in.length - 1, 0, pre.length - 1);
    }

    private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex,
                            int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preLeft]);
        int inMid = inIndex.get(root.val);

        root.left = helper(pre, inIndex, inLeft, inMid - 1,
                preLeft + 1, preLeft + inMid - inLeft);
        root.right = helper(pre, inIndex, inMid + 1, inRight,
                preRight + inMid - inRight + 1, preRight);
        return root;
    }
}
