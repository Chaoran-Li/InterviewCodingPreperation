package com.chaoran;

/**
 * Created by chaoranli on 8/12/17.
 */
public class LongestCrossOf1s {

    public int longest(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] leftUp = leftUp(matrix, n, m);
        int[][] rightDown = rightDown(matrix, n, m);
        return merge(leftUp, rightDown, n, m);
    }

    private int[][] leftUp(int[][] matrix, int n, int m) {
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        left[i][j] = 1;
                        up[i][j] = 1;
                    } else if (i == 0) {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = 1;
                    } else if (j == 0) {
                        left[i][j] = 1;
                        up[i][j] = up[i - 1][j] + 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                    }
                }
            }
        }
        merge(left, up, n, m);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int n, int m) {
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i= n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == n - 1 && j == m - 1) {
                        right[i][j] = 1;
                        down[i][j] = j;
                    } else if (i == n - 1) {
                        right[i][j] = right[i][j + 1] + 1;
                        down[i][j] = 1;
                    } else if (j == m - 1) {
                        right[i][j] = 1;
                        down[i][j] = down[i + 1][j] + 1;
                    } else {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }
        merge(right, down, n, m);
        return right;
    }

    private int merge(int[][] a, int[][] b, int n, int m) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = Math.min(a[i][j], b[i][j]);
                result = Math.max(result, a[i][j]);
            }
        }
        return result;
    }
}
