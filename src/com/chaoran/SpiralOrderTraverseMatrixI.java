package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 8/4/17.
 */
public class SpiralOrderTraverseMatrixI {

    public List<Integer> spiralTraverse(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        traverseHelper(matrix, 0, matrix.length, res);
        return res;
    }

    private void traverseHelper(int[][] matrix, int offset, int size, List<Integer> res) {
        if (size == 0) {
            return;
        }
        //corner case: when the matrix only has one element
        if (size == 1) {
            res.add(matrix[offset][offset]);
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[offset][i + offset]);
        }
        for (int j = 0; j < size - 1; j++) {
            res.add(matrix[j + offset][offset + size - 1]);
        }
        for (int l = size - 1; l >= 1; l--) {
            res.add(matrix[offset + size - 1][l + offset]);
        }
        for (int k = size - 1; k >= 1; k--) {
            res.add(matrix[k + offset][offset]);
        }

        traverseHelper(matrix, offset + 1, size - 2, res);
    }
}
