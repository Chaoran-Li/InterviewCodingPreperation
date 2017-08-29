package com.chaoran;

/**
 * Created by chaoranli on 2/19/17.
 * Given an array with couple of float numbers. Return the max value of them.
 * 空数组返回0，只有一个元素返回元素本身
 * 设置最大数为第一个元素，从第二个元素开始遍历数组
 * 把比max大的元素赋值给max
 */
public class MaxOfArray {

    public static float max(float[] nums2) {
        float max = nums2[0];
        if(nums2.length == 0) {
            return (float) 0;
        }
        if(nums2.length == 1) {
            return nums2[0];
        }

        for(int i = 1; i < nums2.length; i++) {
            if(nums2[i] > max) {
                max = nums2[i];
            }
        }
        return max;
    }
}
