package com.chaoran;

/**
 * Created by chaoranli on 11/12/17.
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }

        int round = n / 2;
        for (int level = 0; level < round; level++) {
            int left = level;
            int right = n - 2 - level;
            for (int i = level; i <= right; i++) {
                int tmp = matrix[left][i];
                matrix[left][i] = matrix[n - 1- i][left];
                matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
                matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
                matrix[i][n - 1 - left] = tmp;
            }
        }
    }
}
