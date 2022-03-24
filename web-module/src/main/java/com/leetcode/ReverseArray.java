package com.leetcode;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String[] args) {
        print(reverseArray(new int[]{1,2,3,4,5,6,7}));
        print(reverseArray(new int[]{1,2,3,4,5,6,7,8}));
    }

    private static void print(int[] arr) {
        System.out.println("[");
        for (int j : arr ) {
            System.out.println(j +",");
        }
        System.out.println("]");
    }

    private static int[] reverseArray(int[] arr) {
        if (arr.length ==0 || arr.length ==1) {
            return arr;
        }
        int temp=0;
        for(int x=0; x<arr.length/2; x++){
            temp = arr[x];
            arr[x] = arr[arr.length-x-1];
            arr[arr.length-x-1] = temp;
        }
        return arr;
    }
}
