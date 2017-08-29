package com.chaoran;

/**
 * Created by chaoranli on 7/25/17.
 */
public class SpaceRemove {

    public String remove(String input) {
        if (input.isEmpty()) {
            return input;
        }

        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;

        while (fast < array.length) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                fast++;
            } else {
                array[slow++] = array[fast++];
            }

        }
        if (slow > 0 && array[slow - 1] == ' ') {
            return new String(array, 0, slow - 1);
        }
        return new String(array, 0, slow);
    }

}
