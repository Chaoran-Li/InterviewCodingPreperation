package com.chaoran;

/**
 * Created by chaoranli on 6/29/17.
 */
public class InsertNodeIntoList {

    public ListNode insert(ListNode head, int target) {
        ListNode newNode = new ListNode(target);
        if (head == null || head.val > target) {

            return newNode;
        }

        if (head.val >= target) {
            head.next = insert(head.next, target);
        }
        return head;
    }
}
