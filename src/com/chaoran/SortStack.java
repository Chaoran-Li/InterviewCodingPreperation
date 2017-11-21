package com.chaoran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chaoranli on 11/21/17.
 * using another stack to sort a input stack
 */
public class SortStack {

    public Deque<Integer> sortByTwoStacks(Deque<Integer> stack) {
        Deque<Integer> tmpStack = new LinkedList<>();
        helper(stack, tmpStack, 0);
        return stack;

    }

    private void helper(Deque<Integer> stack, Deque<Integer> tmpStack, int offset) {
        if (offset == stack.size() - 1) {
            return;
        }

        int min = stack.pop();
        int count = 1;
        for (int i = stack.size() - offset; i > 0; i--) {
            if (stack.peek() < min) {
                for (int k = 0; k < count; k++) {
                    tmpStack.push(min);
                }
                min = stack.pop();
                count = 1;
            } else if (stack.peek() == min) {
                min = stack.pop();
                count++;
            } else {
                tmpStack.push(stack.pop());
            }
        }
        for (int j = 0; j < count; j++) {
            stack.push(min);
        }
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }

        helper(stack, tmpStack, offset + count);
    }
}
