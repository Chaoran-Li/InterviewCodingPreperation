package com.chaoran;

/**
 * Created by chaoranli on 3/16/18.
 */
public class RemoveAdjacentRepeatedCharactersIII {

    public String deDup(String input) {
        // Write your solution here
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        int end = -1;
        int fast = 0;
        while (fast < array.length) {
            if (end == -1 || array[end] != array[fast]) {
                array[++end] = array[fast++];
            } else {
                end--;
                while (fast < array.length && array[fast] == array[fast - 1]) {
                    fast++;
                }
            }
        }
        return new String(array, 0, end + 1);
    }
}
