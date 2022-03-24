package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayOccurrence {

    public static void main(String[] args) {
        ArrayOccurrence arrayOccurrence = new ArrayOccurrence();
        System.out.println(arrayOccurrence.occurrence(new int[]{1, 3, 3, 1, 4}));
    }

    public int occurrence(int[] values){

        //if the elements in the array are valid.
        //check for null and throw exception
        Set<Integer> valueOccurrences = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            if(!valueOccurrences.add(values[i])){
                return values[i];
            }
        }
        throw new IllegalArgumentException("no duplicates in the array");
    }

    public int occurrenceWithIterations(int[] values){

        for (int i = 0; i < values.length; i++) {
            int v  = values[i];
            for (int j = i+1; j < values.length; j++) {
                if (values[j] == v) {
                    return v;
                }
            }
        }
        throw new IllegalArgumentException("no duplicates in the array");
    }
}
