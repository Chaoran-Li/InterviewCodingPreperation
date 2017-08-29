package com.chaoran;

/**
 * Created by chaoranli on 7/28/17.
 */
public class RemoveAdjacentRepeatedCharactersI {

    public String remove(String input) {
        if (input == null) {
            return input;
        }

        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (fast == 0 || array[fast] != array[fast - 1]) {
                array[slow++] = array[fast++];
            } else {
                fast++;
            }
        }
        return new String(array, 0, slow);
    }
}
