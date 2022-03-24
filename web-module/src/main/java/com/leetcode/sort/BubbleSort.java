package com.leetcode.sort;

import java.util.SortedSet;

public class BubbleSort implements Sort {

    public void sort(int[] values) {
        int temp;
        for (int i = 0; i < values.length -1; i++) {
            for (int j = 0; j < values.length - i -1; j++) {
                if(values[j] > values[j+1]){
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{5, 8, 1, 6, 9, 2};
        BubbleSort bs = new BubbleSort();
        bs.sort(values);

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
        }
        System.out.print("  ");
    }
}
