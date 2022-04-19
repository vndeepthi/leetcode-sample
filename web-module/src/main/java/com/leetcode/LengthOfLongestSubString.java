package com.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class LengthOfLongestSubString {

    public int lengthOfLongestSubstring(final String s) {
        String res = "";
        for (int i = 0; i < s. length(); i++) {
            for (int j = i+1; j < s. length(); j++) {
                String tempSubs = s.substring(i,j);
                if(hasUniqueChars(tempSubs) && tempSubs.length() > res.length()){
                    res = tempSubs;
                }
                System. out. println(s.substring(i,j));
            }
        }
        System.out.println("res :: " + res);
        System.out.println(" length :: " + res.length());
        return res.length();
    }

    private boolean hasUniqueChars(String tempSubs) {
        Set<String> res = new TreeSet<>();
        for (int i = 0; i < tempSubs. length(); i++) {
            if (res.add(tempSubs.substring(i, i+1))){
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] s){
        LengthOfLongestSubString l = new LengthOfLongestSubString();
        l.lengthOfLongestSubstring("ppwwekww");
        l.lengthOfLongestSubstring("abcabcbb");
        l.lengthOfLongestSubstring("bbbbb");
    }
}
