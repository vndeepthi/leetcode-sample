package com.leetcode.sort;

public class InsertionSort {

    public void sort(int[] values) {
        // for every value , start from the one index before and
        //go until 0 and see if the element is greater shift the value to the right
        
        for (int i = 0; i < values.length; i++) {
            int current = values[i];
            int j = i-1;
            while(j >=0 && values[j] > current){
                values[j+1] = values[j];
                j--;
            }
            values[j+1] = current;
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{5, 8, 1, 6, 9, 2};
        InsertionSort is = new InsertionSort();
        is.sort(values);

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
        }
        System.out.print("  ");
    }
}
