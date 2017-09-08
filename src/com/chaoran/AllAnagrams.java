package com.chaoran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaoranli on 9/6/17.
 */
public class AllAnagrams {

    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> res = new ArrayList<>();
        if (l == null) {
            return res;
        }
        if (s.length() > l.length()) {
            return res;
        }

        Map<Character, Integer> map = countMap(s);
        int match = 0;
        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if(count == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                res.add(i - s.length() + 1);
            }
        }
        return res;
    }

    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }
}
