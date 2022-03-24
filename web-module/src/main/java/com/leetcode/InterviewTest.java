package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterviewTest {

    public static void main(String[] args) {

        final String input = "abcdefgh" ;
        final String subStringValue = "cde";

        Pattern p = Pattern.compile("cde");
        Matcher m = p.matcher("abcdefgh");
        while (m.find()) {
            System.out.println("position ---" + m.start());
        }

        final Map<String, Integer> subStringIndexMap =  new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length() ; j++) {
                subStringIndexMap.put(input.substring(i, j), i);
            }
        }
        if (subStringIndexMap.get(subStringValue) != null) {
            System.out.println("position ---"+ subStringIndexMap.get(subStringValue));
        }
    }
}
