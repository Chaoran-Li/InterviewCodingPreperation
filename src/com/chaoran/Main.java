package com.chaoran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chaoranli on 10/16/17.
 */
public class Main {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        SortStack test = new SortStack();
        test.sortByTwoStacks(stack);

        for (int i = stack.size(); i > 0; i--) {
            System.out.print(stack.pop());
        }
    }
}
