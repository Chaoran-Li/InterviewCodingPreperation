package com.chaoran;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chaoranli on 10/7/17.
 */
public class MergeKSortedArray {
    /**
     * k way merge
     * use heap to track k elements from each of rows, literate very row of matrix
     * time complexity: O(nklogk) very element do 1 time offer and 1 time poll action
     * there are nk elements
     * space complexity: O(k + n) k elements in heap, there are n elements array in the first place
     */
     public int[] merge(int[][] arrayOfArrays) {
         PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>() {
             @Override
             public int compare(Element o1, Element o2) {
                 if (o1.val == o2.val) {
                     return 0;
                 }
                 return o1.val < o2.val ? -1 : 1;
             }
         });

         int length = 0;
         for (int i = 0; i < arrayOfArrays.length; i++) {
             int[] array = arrayOfArrays[i];
             length = length + array.length;
             if (array.length != 0) {
                 minHeap.offer(new Element(array[0], i, 0));
             }
         }
         int[] res = new int[length];

         int j = 0;
         while (!minHeap.isEmpty()) {
             Element cur = minHeap.poll();
             res[j++] = cur.val;
             if (cur.indexInArray < arrayOfArrays[cur.indexOfArray].length - 1) {
                 minHeap.offer(new Element(arrayOfArrays[cur.indexOfArray][cur.indexInArray + 1],
                         cur.indexOfArray, cur.indexInArray + 1));
             }
         }
         return res;
     }

    class Element {
        int val;
        int indexOfArray;
        int indexInArray;
        public Element(int val, int indexOfArray, int indexInArray) {
            this.val = val;
            this.indexOfArray = indexOfArray;
            this.indexInArray = indexInArray;
        }
    }
}


