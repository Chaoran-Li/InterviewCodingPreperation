package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 3/5/18.
 * time complexity: O(m * n)
 * space complexity: O(1)
 */
public class PrintMatrixZigZag {

    public List<Integer> zigZag(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return null;
        } else if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int level = 0;
        int indicator = 0;
        while (level < matrix.length) {
            if (indicator == 0) { // from left to right
                for (int i = 0; i < matrix[0].length; i++) {
                    res.add(matrix[level][i]);
                }
            } else { // from right to left
                for (int i = matrix[0].length - 1; i >= 0; i--) {
                    res.add(matrix[level][i]);
                }
            }
            indicator = indicator == 0 ? 1 : 0;
            level++;
        }
        return res;
    }
}
