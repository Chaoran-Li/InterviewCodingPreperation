package com.chaoran;

import java.util.*;

/**
 * Created by chaoranli on 6/2/17.
 */
public class StackWithMin {
    Deque<Integer> minStack;
    Deque<Integer> min;

    public StackWithMin() {
        minStack = new LinkedList<> ();
        min = new LinkedList<> ();
    }

    public void push(int number) {
        if (min.isEmpty() || number <= min.peek()) {
            minStack.push(number);
            min.push(number);
        } else {
            minStack.push(number);
        }
    }

    public Integer pop() {
        if (minStack.isEmpty()) {
            return null;
        }
        if (minStack.peek().equals(min.peek())) {
            minStack.pop();
            min.pop();
        }
        return minStack.pop();
    }

    public Integer peek() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peek();
    }

    public Integer min() {
        if (min.isEmpty()) {
            return null;
        }
        return min.peek();
    }
}
