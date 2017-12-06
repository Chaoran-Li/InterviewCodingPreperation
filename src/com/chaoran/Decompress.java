package com.chaoran;

/**
 * Created by chaoranli on 11/29/17.
 */
public class Decompress {

    public String decompress(String input) {
        if (input.length() < 2) {
            return null;
        }

        int i = 0;
        int j = 1;
        StringBuilder sb = new StringBuilder();

        while (i < input.length() - 1) {
            char character = input.charAt(i);
            int number = input.charAt(j) - '0';
            reconstruct(character, number, sb);
            i++;
            j++;
        }
        return sb.toString();
    }

    private void reconstruct(char character, int number, StringBuilder sb) {
        for (int i = 1; i <= number; i++) {
            sb.append(character);
        }
    }
}
