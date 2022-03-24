package com.leetcode;

public class GreatestOfRight {
    public int[] replaceElements(int[] arr) {
        int maxRight = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                arr[i] = -1;
            } else {
                maxRight = 0;
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j] > maxRight){
                        maxRight = arr[j];
                    }
                }
                arr[i] = maxRight;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        GreatestOfRight gr = new GreatestOfRight();
        int arr[] = gr.replaceElements(new int[]{17,18,5,4,6,1});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
