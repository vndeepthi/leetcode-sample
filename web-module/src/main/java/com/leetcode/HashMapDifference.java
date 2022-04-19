package com.leetcode;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapDifference {

    /*
Write a function to compare two maps, return true if they are equal,
otherwise, print out the first difference then return false.
All keys are Strings, values could be either Strings or maps of the same structure.
*/


    // Main class should be named 'Solution'
        public static void main(String[] args) {
            Map<String, Object> map1 = new HashMap<>();
            Map<String, Object> map2 = new HashMap<>();
            Map<String, String> innerMap = new HashMap<>();
            innerMap.put("l", "l1");
            map1.put("g", innerMap);
            map2.put("g", innerMap);

            boolean result = compareMaps(map1, map2);
            if (result) {
                System.out.println("no differences");
            }

            //Test case 2
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            Map<String, String> innerMap2 = new HashMap<>();
            innerMap.put("l", "l2");
            map1.put("g", innerMap);
            map2.put("g", innerMap2);

            result = compareMaps(map1, map2);
            if (result) {
                System.out.println("no differences");
            } else {
                System.out.println("fail");
            }

            //Test case 3
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            Map<String, String> innerMap3 = new HashMap<>();
            innerMap3.put("l", "l1");
            innerMap3.put("l1", "l3");
            map1.put("g", innerMap);
            map2.put("g", innerMap3);

            result = compareMaps(map1, map2);
            if (result) {
                System.out.println("no differences");
            } else {
                System.out.println("fail");
            }

            //Test case 4
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            Map<String, Integer> innerMap4 = new HashMap<>();
            innerMap4.put("l", 50);
            map1.put("g", innerMap);
            map2.put("g", innerMap4);

            result = compareMaps(map1, map2);
            if (result) {
                System.out.println("no differences");
            } else {
                System.out.println("fail");
            }
        }

        public static boolean compareMaps(Map<String, Object> map1, Map<String, Object> map2) {

            for(String key : map2.keySet()) {
                if (!map1.containsKey(key)) {
                    System.out.println("key not found in map1" + key);
                    return false;
                }
            }

            for(String key1 : map1.keySet()) {
                if (!map2.containsKey(key1)) {
                    System.out.println("key not found in map2" + key1);
                    return false;
                } else {
                    Object value2 = map2.get(key1);
                    Object value1 = map1.get(key1);
                    if (value1 instanceof String && value2 instanceof String) {
                        if (!Objects.equals(value2, value1)) {
                            System.out.println("difference in values for key" + key1 + "value" + value2 + " "+ value1);
                            return false;
                        }
                    } else {if (value1 instanceof Map && value2 instanceof Map) {
                        Map valMap2 = (Map) value2;
                        Map valMap1 = (Map) value1;
                        boolean innerRes = compareMaps(valMap1, valMap2);
                        System.out.println("innerRes" + innerRes);
                        if (innerRes ) {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        System.out.println("value types don't match'");
                        return false;
                    }
                    }
                }
            }
            return true;
        }
    }

