package com.chaoran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chaoranli on 12/4/17.
 * time complexity: O(n)
 */
public class LargestRectangleInHistogram {

    public int largest(int[] array) {
        if (array == null) {
            return 0;
        }

        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= array.length; i++) {
            int cur = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int heigth = array[stack.pollFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                result = Math.max(result, heigth * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }
}
