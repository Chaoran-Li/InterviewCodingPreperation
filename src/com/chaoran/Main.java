package com.chaoran;

/**
 * Created by chaoranli on 10/16/17.
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5};
        int[] b = {};
        KthSmallestInTwoSortedArray test = new KthSmallestInTwoSortedArray();
        System.out.println(test.kth(a, b, 4));
    }
}
