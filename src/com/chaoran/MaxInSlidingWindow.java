package com.chaoran;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chaoranli on 2/18/18.
 * Given an integer array and a sliding window of size k,
 * find the maximum value of each window
 * the given array is not null and is not empty
 */
public class MaxInSlidingWindow {

    public List<Integer> max(int[] array, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> window = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            while (!window.isEmpty() && array[window.peekLast()] <= array[i]) {
                window.pollLast();
            }
            if (!window.isEmpty() && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            window.offerLast(i);
            if (i >= k - 1) {
                res.add(array[window.peekLast()]);
            }
        }
        return res;
    }

}
