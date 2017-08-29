package com.chaoran;

/**
 * Created by chaoranli on 8/8/17.
 */
public class SpiralOrderGenerate {

    public int[][] spiralGenerate(int m, int n) {
        int[][] matrix = new int[m][n];
        if (m == 0 || n ==0) {
            return matrix;
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = i + 1;
            }
            return matrix;
        } else if (n == 1){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = i + 1;
            }
            return matrix;
        }

        helper(0, n - 1, 0, m - 1, 1, matrix);
        return matrix;
    }

    private void helper(int left, int right, int up, int down, int counter, int[][] matrix) {
        if (left > right || up > down) {
            return;
        } else if (left == right) {
            matrix[left][right] = counter;
            return;
        }

        for (int i = left; i <= right - 1; i++) {
            matrix[up][i] = counter++;
        }
        for (int i = up; i <= down - 1; i++) {
            matrix[i][right] = counter++;
        }
        for (int i = right; i >= left + 1; i--) {
            matrix[down][i] = counter++;
        }
        for (int i = down; i >= up + 1; i--) {
            matrix[i][left] = counter++;
        }
        helper(left + 1, right - 1, up + 1, down - 1, counter, matrix);
    }
}
