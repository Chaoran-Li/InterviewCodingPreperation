package com.chaoran;

/**
 * Created by chaoranli on 12/5/17.
 */
public class StringReplaceFirstOcurrence {

    public String replaceFirstOcurence(String input, String s, String t) {
        // input, s and t are not null or empty
        char[] array = input.toCharArray();
        if (s.length() <= t.length()) {
            return replaceLonger(array, s, t);
        } else {
            return replaceShorter(array, s, t);
        }
    }

    private String replaceShorter(char[] input, String s, String t) {
        int fast = 0;
        int slow = findMatch(input, s);
        fast = fast + slow + s.length();
        for (int i = 0; i < t.length(); i++) {
            input[slow++] = t.charAt(i);
        }

        while (fast < input.length) {
            input[slow++] = input[fast++];
        }
        return new String(input, 0, slow);
    }

    private String replaceLonger(char[] input, String s, String t) {
        char[] result = new char[input.length + (t.length() - s.length())];
        int slow = result.length - 1;
        int fast = input.length - 1;
        int end = findMatch(input, s) + t.length() - 1;
        while (slow >= 0) {
            if (slow >= 0 && slow == end) {
                for (int i = t.length() - 1; i >= 0; i--) {
                    result[slow--] = t.charAt(i);
                }
            } else {
                result[slow--] = input[fast--];
            }
        }
        return new String(result);
    }

    private int findMatch(char[] input, String s) {
        for (int i = 0; i < input.length - s.length(); i++) {
            if (equals(input, i, s)) {
                return i;
            }
        }
        return -1;
    }

    private boolean equals(char[] input, int index, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (input[index + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
