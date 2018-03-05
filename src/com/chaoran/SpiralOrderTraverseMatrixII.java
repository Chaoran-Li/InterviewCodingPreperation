package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 8/9/17.
 */
public class SpiralOrderTraverseMatrixII {

    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        } else if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        } else if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }
        helper(0, matrix[0].length - 1, 0, matrix.length - 1, result, matrix);
        return result;
    }

    private void helper(int left, int right, int up, int down, List<Integer> result, int[][] matrix) {
        if (left > right || up > down) {
            return;
        } else if (left == right) {
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][left]);
            }
            return;
        } else if (up == down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            return;
        }

        for (int i = left; i <= right - 1; i++) {
            result.add(matrix[up][i]);
        }
        for (int i = up; i <= down - 1; i++) {
            result.add(matrix[i][right]);
        }
        for (int i = right; i >= left + 1; i--) {
            result.add(matrix[down][i]);
        }
        for (int i = down; i >= up + 1; i--) {
            result.add(matrix[i][left]);
        }
        helper(left + 1, right - 1, up + 1, down - 1, result, matrix);
    }
}
