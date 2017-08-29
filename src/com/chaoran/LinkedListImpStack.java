package com.chaoran;

/**
 * Created by chaoranli on 7/12/17.
 */
public class LinkedListImpStack {

    private ListNode head;
    private int size;

    public void push(int target) {
        ListNode newNode = new ListNode(target);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Integer pop() {
        if (size == 0) {
            return null;
        } else {
            int val = head.val;
            head = head.next;
            size--;
            return val;
        }
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        } else {
            return head.val;
        }
    }
}
