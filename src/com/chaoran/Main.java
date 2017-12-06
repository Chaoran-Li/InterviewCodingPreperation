package com.chaoran;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chaoranli on 10/16/17.
 */
public class Main {

    public static void main(String[] args) {
        String input = "diedjfirfjfirui";
        String s = "irf";
        String t = "a";
        StringReplaceFirstOcurrence test = new StringReplaceFirstOcurrence();
        String res = test.replaceFirstOcurence(input, s, t);
        for (int i = 0; i < res.length(); i++) {
            System.out.print(res.charAt(i));
        }
    }
}
