package com.chaoran;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaoranli on 10/26/17.
 * pure storage interview question
 */
public class ValidSquare {

    public boolean isValid(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dis = {getDistance(p1, p2), getDistance(p1, p3), getDistance(p1, p4), getDistance(p2, p3),
                getDistance(p2, p4), getDistance(p3, p4)};

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i : dis) {
            max = Math.max(max, i);
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }

        }

        return map.get(max) == 2 && map.size() == 2;
    }

    private int getDistance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = b[1] - b[1];
        return x * x + y * y;
    }
}
