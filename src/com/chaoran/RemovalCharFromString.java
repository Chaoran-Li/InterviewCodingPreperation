package com.chaoran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chaoranli on 7/25/17.
 * Don't use remove method in String, it is so expensive
 * time complexity: O(n)
 * space complexity: O(n)
 */
public class RemovalCharFromString {

    public String removal(String input, String t) {
        if (input == null || input.length() == 0 || t == null || t.length() == 0) {
            return new String();
        }

        char[] inputArray = input.toCharArray();
        Set<Character> targetSet = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            targetSet.add(t.charAt(i));
        }

        int i = 0;
        int j = 0;
        while (j < inputArray.length) {
            if (targetSet.contains(inputArray[j])) {
                j++;
            } else {
                inputArray[i++] = inputArray[j++];
            }
        }
        char[] result = new char[i];
        for (int k = 0; k < i; k++) {
            result[k] = inputArray[k];
        }
        return new String(result);
    }
}
