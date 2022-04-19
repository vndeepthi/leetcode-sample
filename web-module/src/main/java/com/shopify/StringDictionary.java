package com.shopify;

import java.util.*;

public class StringDictionary {

    public static void main(String[] args) {
        String sentence1 = "Practise makes perfect";
        String sentence2 = "Practise perfect";
        Set<String> dictionary1 = Set.of("Practise", "perfect", "makes");
        Set<String> dictionary2 = Set.of("Practise", "makes");

        System.out.println(isValid(dictionary1, sentence1));
        System.out.println(isValid(dictionary2, sentence2));

    }

    private static boolean isValid(Set<String> dictionary, String sentence){
        String[] sentenceWords = sentence.split(" ");

        for(String word : sentenceWords){
            if(!(dictionary.contains(word) || dictionary.contains(word.toUpperCase())
                    || dictionary.contains(word.toLowerCase()))) return false;
        }
        return true;
    }
}
