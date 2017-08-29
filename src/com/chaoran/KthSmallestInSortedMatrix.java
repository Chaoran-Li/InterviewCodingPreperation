package com.chaoran;

import javafx.scene.control.Cell;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chaoranli on 7/31/17.
 * given a int matrix, every row and every column is sorted by ascending order
 * find the kth smallest element
 * 
 */
public class KthSmallestInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;

        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[row][column];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < row && !visited[cur.row + 1][cur.column]) {
                minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
            }
            if (cur.column + 1 < column && !visited[cur.row][cur.column + 1]) {
                minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    class Cell {
        int row;
        int column;
        int value;

        Cell(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}

