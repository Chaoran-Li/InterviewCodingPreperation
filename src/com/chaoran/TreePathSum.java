package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 3/4/17.
 */
public class TreePathSum {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, path, result, root.val, target);
        return result;
    }

    public void helper(TreeNode root,
                       ArrayList<Integer> path,
                       List<List<Integer>> result,
                       int sum,
                       int target) {

        if(root.left == null && root.right == null) {
            if(sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }

        if(root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, result, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }

        if(root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, result, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
}
