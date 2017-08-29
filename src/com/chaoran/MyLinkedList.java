package com.chaoran;

/**
 * Created by chaoranli on 5/31/17.
 */
public class MyLinkedList {

    public int length(ListNode head) {

        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode getIndex(ListNode head, int index) {
        while (index > 0 && head != null) {
            head = head.next;
            index--;
        }
        return head;
    }


    public ListNode appendHead(ListNode head, int node) {
        ListNode newHead = new ListNode(node);
        newHead.next = head;
        return newHead;
    }

    public ListNode appendTail(ListNode head, int node) {
        if (head == null) {
            return new ListNode(node);
        }

        ListNode tail = new ListNode(node);
        while (head.next != null) {
            head = head.next;
        }
        head.next = tail;
        return head;
    }

    //assume no duplicate element in this LinkedList
    public ListNode remove(ListNode head, int target) {
        if (head == null) {
            return null;
        }

        if (target == head.val) {
            return head.next;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (target == cur.val) {
                prev.next = cur.next;
            }
            prev = prev.next;
            cur = cur.next;
        }
        return head;
    }
}
