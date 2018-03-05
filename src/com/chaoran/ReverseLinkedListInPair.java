package com.chaoran;

/**
 * Created by chaoranli on 8/4/17.
 */
public class ReverseLinkedListInPair {

    public ListNode reverseInPairI(ListNode head) {
        // recursive way
        if (head == null || head.next == null) {
            return head;
        }

        ListNode subHead = head.next;
        head.next = reverseInPairI(head.next.next);
        subHead.next = head;
        return subHead;
    }

    // iterative way
    public ListNode reverseInPairII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        ListNode cur = head;

        while (cur == null || cur.next == null) {
            ListNode curNext = cur.next;
            ListNode nextNext = curNext.next;

            prev.next = curNext;
            nextNext.next = cur;
            cur.next = nextNext;

            prev = cur;
            cur = nextNext;
        }
        return dummy.next;
    }
}
