package com.leetcode;

import java.awt.desktop.PreferencesEvent;

public class ReverseInteger {

    public int reverse(final int x) {
        int value = x;
        int result = 0;
        while (value  > 0) {
           int digit = value % 10;
            System.out.println("digit" + digit);
            result = result * 10 + digit ;
            System.out.println("result" + result);
            value /=10;
        }

        return result ;
    }

    public static void main(final String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(123));
    }
}
