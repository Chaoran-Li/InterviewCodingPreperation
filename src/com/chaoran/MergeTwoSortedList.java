package com.chaoran;

/**
 * Created by chaoranli on 6/6/17.
 */
public class MergeTwoSortedList {

    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (one != null && two != null) {
            if (one.val <= two.val) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }

        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }
}
