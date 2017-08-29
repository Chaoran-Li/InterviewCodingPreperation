package com.chaoran;

/**
 * Created by chaoranli on 8/4/17.
 */
public class ReverseLinkedListInPair {

    public ListNode reverseInPair(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode subHead = head.next;
        head.next = reverseInPair(head.next.next);
        subHead.next = head;
        return subHead;
    }
}
