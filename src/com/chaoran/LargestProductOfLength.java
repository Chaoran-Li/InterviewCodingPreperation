package com.chaoran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by chaoranli on 12/2/17.
 */
public class LargestProductOfLength {

    public  int largestProduct(String[] dict) {

        HashMap<String, Integer> bitMasks = getBitMasks(dict);
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return 0;
                }
                return o1.length() < o2.length() ? 1 : -1;
            }
        });

        int largest = 0;
        for (int i = 1; i < dict.length; i++) {
            for (int j = 0; j < i; j++) {
                int product = dict[i].length() * dict[j].length();
                if (product <= largest) {
                    break;
                }
                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);
                if ((iMask & jMask) == 0) {
                    largest = product;
                }
            }
        }
        return largest;
    }

    private HashMap<String, Integer> getBitMasks(String[] dict) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : dict) {
            int bitMask = 0;
            for (int i = 0; i < str.length(); i++) {
                bitMask |= 1 << (str.charAt(i) - 'a');
            }
            map.put(str, bitMask);
        }
        return map;
    }
}
