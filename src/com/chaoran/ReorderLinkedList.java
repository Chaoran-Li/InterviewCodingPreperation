package com.chaoran;

import java.util.List;

/**
 * Created by chaoranli on 6/21/17.
 */
public class ReorderLinkedList {

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = partition(head);
        ListNode two = middle.next;
        middle.next = null;
        ListNode one = head;
        return merge(one, reverse(two));
    }

    private ListNode partition(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode two) {
        if (two.next == null) {
            return two;
        }
        ListNode newTwo = reverse(two.next);
        two.next.next = two;
        two.next = null;
        return newTwo;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            cur = cur.next;
            one = one.next;
            cur.next = two;
            two = two.next;
            cur = cur.next;
        }

        if (one == null) {
            cur.next = two;
        }
        if (two == null) {
            cur.next = one;
        }
        return dummy.next;
    }
}
