package com.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = arr[1] = 1;
        IntStream.range(2, 9).forEach(i -> {
            arr[i] = arr[i-1]+arr[i-2];
            System.out.print("," + arr[i]);
        });
    }
}
