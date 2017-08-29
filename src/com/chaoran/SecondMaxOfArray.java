package com.chaoran;

/**
 * Created by chaoranli on 2/19/17.
 *Find the second max number in a given array.
 * 解题思路： 最大数默认为数组第一个数
 * 第二大数设置为min
 * 从第二个数开始遍历数组
 * 如果数组元素大于max，max赋值给secMax，元素值赋值给max
 *如果数组元素小于max，把数组元素赋值给secMax，返回secMax
 */
public class SecondMaxOfArray {

    public static int secondMax(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int secMax = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                secMax = max;
                max = nums[i];
            }
            else {
                if(nums[i] < max) {
                    secMax = nums[i];
                }
            }
        }
        return secMax;
    }
}
