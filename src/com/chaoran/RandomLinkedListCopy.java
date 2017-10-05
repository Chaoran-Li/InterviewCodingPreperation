package com.chaoran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaoranli on 10/4/17.
 * Each of the nodes in the linked list has another pointer pointing to a random node in the list or null.
 * Make a deep copy of the original list.
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class RandomLinkedListCopy {

    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> lookup = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.value);
        RandomListNode cur = newHead;
        lookup.put(head, newHead);

        while (head != null) {
            if (head.next != null) {
                if (!lookup.containsKey(head.next)) {
                    lookup.put(head.next, new RandomListNode(head.next.value));
                }
                cur.next = lookup.get(head.next);
            }
            if (head.random != null) {
                if (!lookup.containsKey(head.random)) {
                    lookup.put(head.random, new RandomListNode(head.random.value));
                }
                cur.random = lookup.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }
}
