package com.chaoran;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chaoranli on 12/9/17.
 */
public class AllUniqueCharacterII {

    public boolean isAllUniqueI(String word) {
        Set<Character> lookup = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (lookup.contains(word.charAt(i))) {
                return false;
            } else {
                lookup.add(word.charAt(i));
            }
        }
        return true;
    }

    public boolean isAllUniqueII(String word) {
        String input = word.toLowerCase();
        int[] lookup = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (lookup[index] == 1) {
                return false;
            } else {
                lookup[index] = 1;
            }
        }
        return true;
    }

    public boolean isAllUniqueIII(String word) {
        int[] lookup = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int row = word.charAt(i) / 32;
            int col = word.charAt(i) % 32;
            if ((lookup[row] >> col & 1) == 1) {
                return false;
            }
            lookup[row] = lookup[row] >> col | 1;
        }
        return true;
    }
}
