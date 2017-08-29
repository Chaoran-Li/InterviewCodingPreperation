package com.chaoran;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Created by chaoranli on 7/5/17.
 */
public class SortNumbersWithTwoStacks {

    public int[] sort(int[] arr) {
        int[] res = new int[arr.length];
        Deque<Integer> buffer = new ArrayDeque<>();
        Deque<Integer> ascStack = new ArrayDeque<>();

        if (arr == null || arr.length <= 1) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            buffer.push(arr[i]);
        }

        while (!buffer.isEmpty()) {
            Integer element = buffer.pop();
            while (!ascStack.isEmpty() && ascStack.peek().intValue() > element.intValue()) {
                buffer.push(ascStack.pop());
            }
            ascStack.push(element);
        }

        for (int j = ascStack.size() - 1; j >= 0; j--) {
            res[j] = ascStack.pop();
        }

        return res;
    }
}
