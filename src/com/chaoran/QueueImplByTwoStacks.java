package com.chaoran;

import java.util.LinkedList;

/**
 * Created by licha on 2017/5/31.
 * time complexity:
 * push(): O(1) add element to the LinkedList's head
 * pop(): amortized O(1) for every single element, pop and move for 1 time at most.
 */
public class QueueImplByTwoStacks {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    public QueueImplByTwoStacks() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public Integer pop() {
        move();
        return out.isEmpty() ? null : out.pollFirst();
    }

    public void push(int value) {
        in.offerFirst(value);
    }

    public Integer peek() {
        move();
        return out.isEmpty() ? null : out.peekFirst();
    }

    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.size() == 0 && out.size() == 0;
    }


}
