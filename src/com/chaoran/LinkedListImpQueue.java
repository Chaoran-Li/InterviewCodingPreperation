package com.chaoran;

/**
 * Created by chaoranli on 7/12/17.
 */
public class LinkedListImpQueue {

    private ListNode head;
    private ListNode tail;

    public void offer(int target) {
        if (tail == null) {
            tail = new ListNode(target);
            head = tail;
        } else if (tail != null && head == null) {
            head = new ListNode(target);
            tail = head;
        } else {
            tail.next = new ListNode(target);
            tail = tail.next;
        }
    }

    public Integer poll() {
        if (head == null) {
            return null;
        } else {
            int val = head.val;
            head = head.next;
            return val;
        }
    }

    public Integer top() {
        if (head == null) {
            return null;
        } else {
            return head.val;
        }
    }
}
