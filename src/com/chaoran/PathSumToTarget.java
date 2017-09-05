package com.chaoran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chaoranli on 9/4/17.
 * Determine if there exists a path (the path can only be from one node to itself or to any of its descendants)
 * the sum of the numbers on the path is the given target number.
 */
public class PathSumToTarget {

    public boolean findTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        Set<Integer> prefixSum = new HashSet<>();
        return helper(root, prefixSum, 0, target);
    }

    private boolean helper(TreeNode root, Set<Integer> prefixSum, int prevSum, int target) {
        prevSum = prevSum + root.val;
        if (prefixSum.contains(prevSum - target)) {
            return true;
        }
        boolean prefix = prefixSum.add(prevSum);
        if (root.left != null && helper(root.left, prefixSum, prevSum, target)) {
            return true;
        }
        if (root.right != null && helper(root.right, prefixSum, prevSum, target)) {
            return true;
        }
        if (prefix) {
            prefixSum.remove(prevSum);
        }
        return false;
    }
}
