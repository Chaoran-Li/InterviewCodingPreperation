package com.chaoran;

/**
 * Created by chaoranli on 8/18/17.
 */
public class ReserviorSampling {
    int count;
    Integer sample;

    public ReserviorSampling() {
        count = 0;
        sample = null;
    }

    public void read(int value) {
        count++;
        int prob = (int) (Math.random() * count);
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}
