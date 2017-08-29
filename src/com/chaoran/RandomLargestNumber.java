package com.chaoran;

/**
 * Created by chaoranli on 8/19/17.
 */
public class RandomLargestNumber {
    private int maxValue;
    private int counter;
    private Integer sample;

    public RandomLargestNumber() {
        maxValue = Integer.MIN_VALUE;
        counter = 0;
        sample = null;
    }

    public void read(int value) {
        if (value > maxValue) {
            maxValue = value;
            counter = 1;
        } else if (value == maxValue) {
            counter++;
        }
        int prob = (int) (Math.random() * counter);
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}
