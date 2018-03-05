package com.chaoran;

/**
 * Created by chaoranli on 6/2/17.
 */
public class MiddleNodeOfLinkedList {

    public ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

