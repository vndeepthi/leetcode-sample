package com.leetcode;

import java.util.*;
import java.util.stream.Stream;

public class Occurrences {

    public static void main(String[] args) {
        Map<Integer, Integer> occurrencesMap = new HashMap<>();
        Stream.of(1,3,4,5,6,2,3,4,5,7,8,9,9,1,1,1,0)
                .forEach(key -> occurrencesMap.merge(key, 1, Integer::sum));
        Comparator<Map.Entry<Integer, Integer>> CompareCondition = Map.Entry.comparingByValue();
        occurrencesMap.entrySet().stream()
                .sorted(CompareCondition.reversed())
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + " ->" + e.getValue()));
    }
}
