package com.chaoran;

/**
 * Created by chaoranli on 10/12/17.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * time complexity: O(n)
 * space complexity: O(1)
 */
public class RemoveDuplicatesFromSortedListI {

    public ListNode removeDup(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {
                slow.next = fast;
                slow = fast;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }
}
