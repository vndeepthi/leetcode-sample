package com.leetcode;

import java.util.HashMap;
import java.util.function.Function;

import static java.util.Optional.ofNullable;

public class LongestPalindrome {

    public int longestPalindrome(final String s) {
        int result = 0;
        final HashMap<Character, Integer> entrySet = new HashMap<>();
        for (char c: s.toCharArray()) {
            Function<Integer, Integer> incrementBy1 = count -> count + 1;
            entrySet.put(c, ofNullable(entrySet.get(c)).map(incrementBy1).orElse(1));
        }
        for (Integer num: entrySet.values() ) {
            if (num % 2 == 0) {
                result = result + num;
            } else {
                result = result + (num -1);
            }
        }

        return (s.length() != result) ? result +1 : result;
    }

    public static void main(final String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("abdfghjccccdda"));
    }
}
