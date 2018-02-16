package com.chaoran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chaoranli on 10/16/17.
 */
public class Main {

    public static void main(String[] args) {
        String input = "aabaa";
        AllPalindrome test = new AllPalindrome();
        System.out.println(test.findAllPalindrome(input));
    }
}
