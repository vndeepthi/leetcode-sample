package com.leetcode.sort;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int minValue = values[i];
            int minValueIndex = i;
            for (int j = i +1; j < values.length; j++) {
                if(minValue > values[j]){
                    minValue = values[j];
                    minValueIndex = j;
                }
            }
            if (i != minValueIndex) {
                int temp = values[i];
                values[i] = minValue;
                values[minValueIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{5,8,1,6,9,2};
        SelectionSort ss = new SelectionSort();
        ss.sort(values);

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
        }
    }
}
