package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRoman {
    public String intToRoman(int num) {
        int input = num;
        StringBuilder result = new StringBuilder();
        Map<Integer, String> romanIntegerTable = new LinkedHashMap<>();
        romanIntegerTable.put(1000, "M");
        romanIntegerTable.put(900, "CM");
        romanIntegerTable.put(500, "D");
        romanIntegerTable.put(400, "CD");
        romanIntegerTable.put(100, "C");
        romanIntegerTable.put(90, "XC");
        romanIntegerTable.put(50, "L");
        romanIntegerTable.put(40, "XL");
        romanIntegerTable.put(10, "X");
        romanIntegerTable.put(9, "IX");
        romanIntegerTable.put(5, "V");
        romanIntegerTable.put(4, "IV");
        romanIntegerTable.put(1, "I");
        for (Integer r: romanIntegerTable.keySet()) {
            System.out.println("------ r"+ r);
            int multiplier = input / r;
            System.out.println("------"+ multiplier);
            if (multiplier != 0) {
                for (int i=0; i< multiplier; i++) {
                    result.append(romanIntegerTable.get(r));
                }
                input = input % r;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(58));
    }
}
