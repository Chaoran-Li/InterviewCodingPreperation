package com.chaoran;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoranli on 7/23/17.
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
}
