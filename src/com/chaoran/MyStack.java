package com.chaoran;

/**
 * Created by chaoranli on 10/27/17.
 */

// using LinkedList implement stack
// only contain Integer
public class MyStack {
    private ListNode head;

    public void push(Integer val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    public Integer pop() {
        if (head != null) {
            ListNode res = head;
            head = head.next;
            res.next = null;
            return res.val;
        }
        return null;
    }

    public Integer peek() {
        if (head != null) {
            return head.val;
        }
        return null;
    }
}
