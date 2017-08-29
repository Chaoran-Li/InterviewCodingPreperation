package com.chaoran;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by chaoranli on 6/30/17.
 * use minheap
 * time complexity: O((n + k)logn)
 * k << n: nlogn
 * k ~ n: O((n + k)logn)
 */
public class KSmallestInUnsortedArray {

    public int[] kSmallestByMinHeap(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        for (int j = 0; j < k; j++) {
            res[j] = minHeap.poll();
        }
        return res;
    }

    /**
     * @param arr
     * @param k
     * @return
     * time complexity: O((n - k)logn)
     * k << n: O(nlogn)
     * k ~ n: O((n - k)logn)
     */
    public int[] kSmallestByMaxHeap(int[] arr, int k) {
        int[] res = new int[k];
        if (arr != null || k > arr.length) {
            return res;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (i < k) {
                maxHeap.offer(arr[i]);
            } else if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
