package com.chaoran;

import java.util.ArrayList;

/**
 * Created by chaoranli on 7/29/17.
 */
public class StringReplace {

    public String replace(String input, String s, String t) {
        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(array, s, t);
        }
        return replaceLonger(array, s, t);
    }

    public String replaceShorter(char[] input, String s, String t) {
        int slow = 0;
        int fast = 0;

        while (fast < input.length) {
            if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }

    public String replaceLonger(char[] input, String s, String t) {
        ArrayList<Integer> matches = getAllMatches(input, s);
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];
        int lastIndex = matches.size() - 1;
        int slow = input.length - 1;
        int fast = result.length - 1;
        while (slow >= 0) {
            if (lastIndex >= 0 && slow == matches.get(lastIndex)) {
                copySubstring(result, fast - t.length() + 1, t);
                fast -= t.length();
                slow -= s.length();
                lastIndex--;
            } else {
                result[fast--] = input[slow--];
            }
        }
        return new String(result);
    }

    private boolean equalSubstring(char[] input, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }

    private ArrayList<Integer> getAllMatches(char[] input, String s) {
        ArrayList<Integer> matches = new ArrayList<>();
        int i = 0;
        while (i <= input.length - s.length()) {
            if (equalSubstring(input, i, s)) {
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }


}
