package com.chaoran;

import java.util.*;

/**
 * Created by chaoranli on 10/14/17.
 */
public class ReconstructBinarTreeWithLevelorderAndInorder {

    public TreeNode reconstruct(int[] in, int[] level) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        List<Integer> levelList = new LinkedList<>();
        for (int num : level) {
            levelList.add(num);
        }
        return helper(levelList, inMap);
    }

    private TreeNode helper(List<Integer> level, Map<Integer, Integer> inMap) {
        if (level.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(level.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : level) {
            if (inMap.get(num) < inMap.get(root.val)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }

        root.left = helper(left, inMap);
        root.right = helper(right, inMap);
        return root;
    }
}
