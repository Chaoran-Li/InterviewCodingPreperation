package com.chaoran;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by chaoranli on 12/2/17.
 */
public class KthSmallestThreeFiveSeven {

    public long kth(int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        minHeap.offer(3 * 5 * 7L);
        visited.add(3 * 5 * 7L);
        while (k > 1) {
            long cur = minHeap.poll();
            if (visited.add(3 * cur)) {
                minHeap.offer(3 * cur);
            }
            if (visited.add(5 * cur)) {
                minHeap.offer(5 * cur);
            }
            if (visited.add(7 * cur)) {
                minHeap.offer(7 * cur);
            }
            k--;
        }
        return minHeap.peek();
    }
}
