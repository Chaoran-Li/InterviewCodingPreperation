package com.chaoran;

/**
 * Created by licha on 2017/6/1.
 * Interative reverse：
 * time complexity: O（n）traverse every node
 * space complexity: O(1) no addition space use
 * Recursive reverse:
 * time complexity: O(n) traverse every node
 * space complexity O(n) n time call stack
 * for every node, make the next node point to the previous one.
 */
public class ReverseLinkedList {

    public ListNode interativeReverse(ListNode head) {
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

    public ListNode recursiveReverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
