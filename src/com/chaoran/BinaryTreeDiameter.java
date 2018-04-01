package com.chaoran;

/**
 * Created by chaoranli on 3/21/18.
 * The diameter is defined as the longest distance from one leaf node to another leaf node.
 * The distance is the number of nodes on the path.
 * step1: get the height of the left subtree and right subtree
 * step2: at cur layer, if height of left subtree is not zero and right subtree is not zero
 * update the final res
 * step3: return the height which is higher + 1 to upper layer
 * time complexity: O(n)
 * space complexity: O(log^n)
 */
public class BinaryTreeDiameter {

    public int diameter(TreeNode root) {
        // Write your solution here.
        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, res);
        int right = helper(root.right, res);

        if (left != 0 && right != 0) {
            res[0] = Math.max(res[0], left + right + 1);
        }
        return left > right ? left + 1 : right + 1;
    }
}
