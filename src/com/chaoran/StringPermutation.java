package com.chaoran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by chaoranli on 7/23/17.
 * time complexity: O(n!)
 * space complexity: O(1)
 */
public class StringPermutation {

    public List<String> permutation(String set) {
        if (set == null) {
            return null;
        }

        char[] array = set.toCharArray();
        List<String> res = new ArrayList<>();
        helper(array, 0, res);
        return res;
    }

    private void helper(char[] array, int index, List<String> res) {
        if (index == array.length) {
            res.add(new String(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, res);
            swap(array, index, i);

        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public List<String> permutationI(String input) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() <= 1) {
            return res;
        }

        char[] array = input.toCharArray();
        StringBuilder tmp = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        helper(array, res, tmp, set);
        return res;
    }

    private void helper(char[] array,
                        List<String> res,
                        StringBuilder tmp,
                        HashSet<Character> set) {
        if (tmp.length() == array.length) {
            res.add(tmp.toString());
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
                tmp.append(array[i]);
                helper(array, res, tmp, set);
                tmp.deleteCharAt(tmp.length() - 1);
                set.remove(array[i]);
            }
        }
    }
}
