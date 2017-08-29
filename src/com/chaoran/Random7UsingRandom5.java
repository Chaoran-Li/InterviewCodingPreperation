package com.chaoran;

/**
 * Created by chaoranli on 8/19/17.
 */
public class Random7UsingRandom5 {

    public int random7() {

        while (true) {
            int random = (int) (5 * Math.random() * 5 + Math.random() * 5);

            if (random <= 21) {
                return random % 7;
            }
        }
    }
}
