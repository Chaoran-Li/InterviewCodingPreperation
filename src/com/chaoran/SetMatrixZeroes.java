package com.chaoran;

/**
 * Created by chaoranli on 3/7/18.
 * time complexity: O(m * n);
 * space complexity: O(1)
 */
public class SetMatrixZeroes {

    public void setZero(int[][] matrix) {
        //Input your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i <= n; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        for (int i = 0; i <= m; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j <= m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstRow) {
            setFirstRow(matrix, 0);
        }
        if (firstCol) {
            setFirstCol(matrix, 0);
        }
    }

    private void setFirstRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }
    private void setFirstCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

}
