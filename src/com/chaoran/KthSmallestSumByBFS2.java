package com.chaoran;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chaoranli on 8/1/17.
 */
public class KthSmallestSumByBFS2 {

    public int kthSmallestSum(int[] A, int[] B, int k) {
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                int sum1 = A[o1.aIndex] + B[o1.bIndex];
                int sum2 = A[o2.aIndex] + B[o2.bIndex];

                if (sum1 == sum2) {
                    return 0;
                }
                return sum1 < sum2 ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[A.length][B.length];
        maxHeap.offer(new Cell(0, 0));
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            Cell cur = maxHeap.poll();
            if (cur.aIndex + 1 < A.length && !visited[cur.aIndex + 1][cur.bIndex]) {
                maxHeap.offer(new Cell(cur.aIndex + 1, cur.bIndex));
                visited[cur.aIndex + 1][cur.bIndex] = true;
            }
            if (cur.bIndex + 1 < B.length && !visited[cur.aIndex][cur.bIndex + 1]) {
                maxHeap.offer(new Cell(cur.aIndex, cur.bIndex + 1));
                visited[cur.aIndex][cur.bIndex + 1] = true;
            }

        }
        Cell result = maxHeap.peek();
        return A[result.aIndex] + B[result.bIndex];
    }

    class Cell {
        int aIndex;
        int bIndex;

        public Cell(int aIndex, int bIndex) {
            this.aIndex = aIndex;
            this.bIndex = bIndex;
        }
    }
}
