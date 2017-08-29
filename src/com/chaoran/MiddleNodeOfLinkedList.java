package com.chaoran;

/**
 * Created by chaoranli on 6/2/17.
 */
public class MiddleNodeOfLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int left = 0;
        int right = 0;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            right++;
        }

        int middle = left + (right - left) / 2;
        int finder = 0;
        ListNode middleNode = head;
        while (finder != middle) {
            middleNode = middleNode.next;
            finder++;
        }
        return middleNode;
    }

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

