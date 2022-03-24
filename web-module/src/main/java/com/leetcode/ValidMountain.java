package com.leetcode;

import java.util.HashSet;

public class ValidMountain {
    public boolean validMountainArray(int[] arr) {
        HashSet<Integer> elements = new HashSet<>();
        if(arr.length <=2){
            return false;
        }
        boolean mountainStarted =false, mountainDown =false;
        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
            } else if (i == 1) {
                if (arr[i] > arr[0]) {
                    mountainStarted =true;
                } else {
                    return false;
                }
            } else if (mountainStarted) {
                /*if (arr[i] > arr[i - 1] && !mountainDown) {
                    continue;
                } else*/ if (arr[i] == arr[i - 1]) {
                    return false;
                } else if (arr[i] < arr[i - 1] && !mountainDown) {
                    mountainDown = true;
                    mountainStarted = false;
                }
            } else if (mountainDown) {
                if (arr[i] >= arr[i - 1]) {
                    return false;
                }/* else {
                    continue;
                }*/
            }
            elements.add(arr[i]);
        }
        if (!mountainDown) {
           return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidMountain vm = new ValidMountain();
        System.out.println(" " + vm.validMountainArray(new int[]{2, 1,0}));
        //System.out.println(" " + vm.validMountainArray(new int[]{3,5,6,7,8,7,6,5,4}));
        System.out.println(" " + vm.validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));
    }
}
