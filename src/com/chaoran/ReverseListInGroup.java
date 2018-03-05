package com.chaoran;

/**
 * Created by chaoranli on 2/25/18.
 */
public class ReverseListInGroup {

    public ListNode reverseInGroup(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur = head;
        int count = n;

        while (cur != null) {
            if (count == 1) {
                ListNode fakeHead = prev.next;
                ListNode tail = cur.next;
                prev.next = null;
                cur.next = null;
                ListNode newHead = reverse(fakeHead);
                prev.next = newHead;
                fakeHead.next = tail;
                prev = fakeHead;
                cur = tail;
            } else {
                count--;
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
