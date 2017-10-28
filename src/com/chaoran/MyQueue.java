package com.chaoran;

/**
 * Created by chaoranli on 10/27/17.
 */

// using LinkedList implement Queue
public class MyQueue {
    ListNode head;
    ListNode tail;

    public void offer(Integer ele) {
        ListNode newNode = new ListNode(ele);
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }

        ListNode res = head;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        res.next = null;
        return head.val;
    }


    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}
