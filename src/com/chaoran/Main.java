package com.chaoran;


/**
 * Created by chaoranli on 10/16/17.
 */
public class Main {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n8 = new ListNode(5);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n8;
        n8.next = n5;
        n5.next = n6;
        n6.next = n7;

        PalindromeList test = new PalindromeList();
        System.out.println(test.isPalin(n1));
    }
}
