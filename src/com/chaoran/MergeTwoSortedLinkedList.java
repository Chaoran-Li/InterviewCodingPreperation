package com.chaoran;

/**
 * Created by chaoranli on 6/29/17.
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class MergeTwoSortedLinkedList {

    public ListNode merge(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }

        if (one.val < two.val) {
            one.next = merge(one.next, two);
            return one;
        } else {
            two.next = merge(one, two.next);
            return two;
        }

    }
}
