package com.chaoran;

/**
 * Created by chaoranli on 12/9/17.
 */
public class HexadecimalRepresentation {

    public String hex(int number) {
        String prefix = "0x";
        if (number == 0) {
            return prefix + number;
        }
        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int reminder = number % 16;
            number = number / 16;
            sb.append(base[reminder]);
        }

        sb.append('x');
        sb.append('0');
        return sb.reverse().toString();
    }
}
