package com.chaoran;

/**
 * Created by chaoranli on 2/20/17.
 *Check a positive number is a palindrome or not.
 * A palindrome number is that if you reverse the whole number
 * you will get exactly the same number.
 */
public class PalindromeNumber {

    public static boolean check(int nums4) {
        String s;
        s = String.valueOf(nums4);
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            char char1 = s.charAt(i);
            char char2 = s.charAt(j);
            if(char1 != char2) {
                return false;
            }
        }
        return true;
    }
}
