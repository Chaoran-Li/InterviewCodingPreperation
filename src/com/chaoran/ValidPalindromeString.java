package com.chaoran;

/**
 * Created by chaoranli on 2/21/17.
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * 解题思路：设置两个指针，一个指向最前一个指向最后
 * 条件一，如果是空字符返回true
 * 条件二，当碰到不是字符也不是数字的时候跳过
 * 条件三，当前面的字母跟后面的字母不一样的时候，直接跳出程序
 */
public class ValidPalindromeString {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))){
                front++;
            }

            if (front == s.length()) {
                return true;
            }

            while (end >= 0 && ! isvalid(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }

        return end <= front;
    }

    private static boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
