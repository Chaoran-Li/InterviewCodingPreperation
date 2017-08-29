package com.chaoran;

/**
 * Created by chaoranli on 6/21/17.
 */
public class IfLinkedListHasCycle {

    public boolean check(ListNode head) {
        if (head == null && head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
