package com.leetcode;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] v = new int[]{0,0,1,1,1,2,2,3,3,4,5,5,5,5,5,6,6,7,7,8,8,9,9};
       // int[] v = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("nextValIndex : " + rd.removeDuplicates(v));
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }

    private int removeDuplicates(int[] values) {
        int nextValIndex = 1;
        outer: for(int i=0; i< values.length; ){
            for (int j=i+1; j<values.length; j++) {
                if (values[i] != values[j]) {
                    values[nextValIndex++] = values[j];
                    i=j+1;
                    continue outer;
                }
            }
            i++;
        }
        System.out.println("nextValIndex" +nextValIndex);
        return nextValIndex;
    }
}
