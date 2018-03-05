package com.chaoran;

/**
 * Created by chaoranli on 2/27/18.
 * Determine if a LinkedList is palindrome.
 */
public class PalindromeList {

    public boolean isPalin(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        ListNode mid = findMiddleNode(head);
        ListNode secondHead = mid.next;
        mid.next = null;
        ListNode newSecHead = interativeReverse(secondHead);

        while (head != null && newSecHead != null) {
            if (head.val != newSecHead.val) {
                return false;
            }
            head = head.next;
            newSecHead = newSecHead.next;
        }
        return true;
    }

    private ListNode findMiddleNode(ListNode head) {
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

    private ListNode interativeReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
