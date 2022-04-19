package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoOfDigits {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(3,0,6,0,7,8,9,0);
        int x = 567899999;
        int noOfDigits = 0;

        for (int i = x; i > 0 ; i/=10) {
            noOfDigits++;
        }

        System.out.println("noOfDigits === " + noOfDigits);
        StringBuffer b = new StringBuffer("p");
        switch("p"){
            case "p" :
                System.out.println("p");
                break;
            case "l":
                System.out.println("l");
        }
        System.out.println("-----------------");

        Pattern p = Pattern.compile("^[a-c]");
        Matcher m = p.matcher("cafeBABE");
        while(m.find()) {
            System.out.println(m.start());
        }
    }
}
