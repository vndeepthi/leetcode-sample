package com.leetcode;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given a String, split it into major parts separated by special char '/'. For each major part that’s split by '/', we can further split it into minor parts separated by '.'.
 *
 * # ### Example 1
 * # str = stripe.com/payments/checkout/customer.john.doe
 * # minor_parts = 2
 *
 * # after Part 1 compression
 * # =>
 * # s4e.c1m/p6s/c6t/c6r.j2n.d1e
 *
 * # after Part 2 compression
 * # =>
 * # s4e.c1m/p6s/c6t/c6r.j5e
 *
 *
 * # ### Example 2
 * # Given:
 * # str = www.api.stripe.com/checkout
 * # minor_parts = 3
 *
 * # (after Part 1 compression)
 * # =>
 * # w1w.a1i.s4e.c1m/c6t
 *
 * # (then after Part 2 compression)
 * # =>
 * # w1w.a1i.s7m/c6t
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compressFull("stripe.com/payments/checkout/customer.john.doe"));
        System.out.println(compressFull("www.api.stripe.com/checkout"));
       // System.out.println(compressFull(null));
    }

    private static String compressFull(final String input){
        if (input == null || input.isEmpty()){
            throw new IllegalArgumentException("input string is null");
        }
        StringCompression sc = new StringCompression();
        String[] firstSplit = input.split("/");
        StringBuilder part1 = new StringBuilder();
        for (int i = 0; i < firstSplit.length; i++) {
            String[] secondSplit = firstSplit[i].split("\\.");
            part1.append(Arrays.stream(secondSplit).map(sc::compress).collect(Collectors.joining(".")));
            part1.append("/");
        }
        //System.out.println("------part1--" + part1);

        String finalRes = Arrays.stream(part1.toString().split("/"))
                .map(val -> sc.compressMinor(val, 2))
                .collect(Collectors.joining("/"));
        System.out.println("finalRes-----" + finalRes);
        return finalRes;
    }

    private String compress(String s){
        if (s == null) {
            throw new IllegalArgumentException("input string is null");
        }
        if (s.length() <= 2 ) {
            return s;
        }
        //System.out.println("compress--"+s);
        return String.valueOf(s.charAt(0)) +
                (s.length() - 2) +
                s.charAt(s.length()-1);
    }

    private String compressMinor(String s, int minorParts){
        String[] splitBy = s.split("\\.");
        if (splitBy.length > minorParts && minorParts >1 ) {
            String combinedString = compress(splitBy[splitBy.length -2] + "." +splitBy[splitBy.length -1]);
            StringBuilder firstString = new StringBuilder();
            for (int i = 0; i < splitBy.length - 2; i++) {
                firstString.append(splitBy[i]);
                firstString.append(".");
            }
            return compressMinor(firstString + combinedString, minorParts-1);
        } else {
            return s;
        }

    }
}
