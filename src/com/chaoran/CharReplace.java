package com.chaoran;

/**
 * Created by chaoranli on 9/6/17.
 */
public class CharReplace {

    public String charReplace(String input, String s, String t) {
        StringBuilder tmp = new StringBuilder();
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);

        while (matchIndex != -1) {
            tmp.append(input, fromIndex, matchIndex).append(t);
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        tmp.append(input, fromIndex, input.length());
        return tmp.toString();
    }
}
