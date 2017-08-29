package com.chaoran;

/**
 * Created by chaoranli on 6/2/17.
 */
public class InsertNodeInSortedLinkedList {

    public ListNode insert(ListNode head, int number) {
        ListNode newNode = new ListNode(number);
        if (head == null || number < head.val) {
            newNode.next = head;
            return newNode;
        }

        ListNode prev = head;

        while (prev.next != null && prev.next.val < number) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }
}
