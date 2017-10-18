package com.chaoran;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chaoranli on 10/15/17.
 * Pure Storage OA #8
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class ValidSequence {

    public int checkValid(String[] events) {
        if (events == null || events.length < 1) {
            return 0;
        }

        int step = 1;
        // Use LIFO(stack) data structure to monitor lock and unlock process
        // In Java, we prefer to use Deque interface instead of using Stack interface
        Deque<String> lockStack = new ArrayDeque<>();
        // use set to determine if only one unique lock at this time
        Set<String> records = new HashSet<>();

        for (String l : events) {
            String[] array = l.split(" ");
            if (array[0].equals("ACQUIRE")) { //When string is ACQUIRE, push to stack
                if (records.contains(array[1])) {
                    return step;
                }
                records.add(array[1]);
                lockStack.push(array[1]);
            } else { // when string is RELEASE, pop from stack
                if (lockStack.isEmpty() || !lockStack.peek().equals(array[1])) {
                    return step;
                }
                lockStack.pop();
                records.remove(array[1]);
            }
            step++;
        }
        if (!lockStack.isEmpty()) {
            return events.length + 1;
        }
        return 0;
    }
}
