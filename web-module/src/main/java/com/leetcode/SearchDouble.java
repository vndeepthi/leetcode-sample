package com.leetcode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SearchDouble {
    /*public boolean checkIfExist(int[] arr) {
        if (arr.length <2 || arr.length >500) {
            return false;
        }
        Hashtable<Integer, Integer> tb = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            Integer halfVal = null;

            if (arr[i]!=0 && arr[i] % 2 == 0) {
                halfVal = arr[i] /2;
                System.out.println(halfVal);
            }
            if (tb.contains(arr[i] *2) ||  (halfVal != null && tb.contains(halfVal))) {
                return true;
            }
            tb.put(i, arr[i]);
        }
        return false;
    }*/

    public static void main(String[] args) {
        SearchDouble sd= new SearchDouble();
        System.out.println(sd.checkIfExist(new int[]{3,1,7,11}));
        System.out.println(sd.checkIfExist(new int[]{7,1,14,11}));
        System.out.println(sd.checkIfExist(new int[]{10,2,5,3}));
        System.out.println(sd.checkIfExist(new int[]{22,1,14,11}));
        System.out.println(sd.checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }

    private boolean checkIfExist(int[] ints) {
        final List<Integer>  list = Arrays.stream(ints).boxed()
                .collect(Collectors.toList());
                for(Integer r : list) {
                    if(list.contains(r*2)){
                        return true;
                    }
                };
       return false;
    }
}
