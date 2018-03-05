package com.chaoran;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chaoranli on 2/27/18.
 */
public class MultipleLevelListToOneLevelList {

    public Node delevel(Node head) {
        if (head == null) {
            return head;
        }

        Node dummy = new Node(0);
        Node cur = dummy;
        Queue<Node> q = new LinkedList<>();

        while (head != null) {
            q.offer(head);
            head = head.next;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node tmp = q.poll();
                cur.next = tmp;
                cur = cur.next;
                if (tmp.child != null) {
                    Node tmpChild = tmp.child;
                    q.offer(tmpChild);
                    while (tmpChild.next != null) {
                        q.offer(tmpChild.next);
                        tmpChild = tmpChild.next;
                    }
                }
            }
        }
        return dummy.next;
    }


}

class Node {
    int val;
    Node next;
    Node child;

    public Node(int val) {
        this.val = val;
    }
}
