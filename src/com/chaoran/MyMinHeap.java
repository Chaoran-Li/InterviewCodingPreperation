package com.chaoran;

/**
 * Created by chaoranli on 7/23/17.
 */
public class MyMinHeap {
    private int[] heap;
    private int size;

    public MyMinHeap(int[] array) {
        if (heap == null || heap.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.heap = array;
        this.size = array.length;
        heapify();
    }

    public void offer(int value) {
        heap[size] = value;
        size++;
        percolateUp(size - 1);
    }

    public int poll() {
        int res = heap[0];
        heap[0] = heap[size - 1];
        size--;
        percolateDown(0);
        return res;
    }

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return heap[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[parentIndex] > heap[index]) {
                swap(heap, parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }

    }

    private void percolateDown(int index) {
        while (index > 0) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            if (heap[leftChild] <= heap[rightChild]) {
                swap(heap, index, leftChild);
            } else {
                swap(heap, index, rightChild);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
