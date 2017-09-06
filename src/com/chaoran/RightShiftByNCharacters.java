package com.chaoran;

/**
 * Created by chaoranli on 9/5/17.
 */
public class RightShiftByNCharacters {

    public String rightShift(String input, int n) {
        if (input == null) {
            return null;
        }

        char[] array = input.toCharArray();
        n = n % array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, n - 1);
        reverse(array, n, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left <= right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
