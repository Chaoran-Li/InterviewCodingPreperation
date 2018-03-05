package com.chaoran;


/**
 * Created by chaoranli on 10/16/17.
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        SpiralOrderTraverseMatrixII test = new SpiralOrderTraverseMatrixII();
        System.out.println(test.spiral(matrix));
    }
}
