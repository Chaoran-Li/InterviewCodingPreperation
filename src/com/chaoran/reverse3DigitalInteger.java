package com.chaoran;

/**
 * Created by chaoranli on 2/19/17.
 * reverse 3 digital number
 * 解题思路：用10除以输入的三位数得到的余数作为反转后数字的百位数
 * 用商再除以10的余数作为十位数
 * 用三位数连续除以10两次后得到的商作为个位数
 */
public class reverse3DigitalInteger {
    static int a, b, c;
    public static int reverseInteger(int number) {
        if (number >= 100 && number < 1000) {
            a = (number % 10) * 100;
            b = (number / 10) % 10 * 10;
            c = (number / 10) / 10;
        }
        return a + b + c;
    }
}
