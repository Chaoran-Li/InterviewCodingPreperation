package com.chaoran;

/**
 * Created by chaoranli on 6/18/17.
 */
public class Insert {
    public ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }

        if (value <= head.val) {
            newNode.next = head;
            return newNode;
        } else {
            ListNode prev = head;
            ListNode cur = head.next;
            while (cur.next != null) {
                if (value <= cur.val) {
                    prev.next = newNode;
                    newNode.next = cur;
                    return head;
                } else {
                    prev = cur;
                    cur = cur.next;
                }
            }
            cur.next = newNode;
            return head;
        }
    }
}
