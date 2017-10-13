package com.chaoran;

/**
 * Created by chaoranli on 10/12/17.
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * time complexity: O(n)
 * space complexity: O(1)
 *
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode removeDup(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null) {
            // skip all duplicate number util reach the last duplicate one
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            // delete duplicate numbers
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = fast.next;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
