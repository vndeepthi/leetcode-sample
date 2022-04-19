package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;

/**
 * A popcorn costs 7$, a soda costs 2.5$, when bought together they cost 9$.
 * Given an input list of dates and the name of the items bought, find the total amount spent.
 * All pairs of soda and popcorn should be treated as a bundle
 * if they were bought on the same date, even if they are not bought one after the other.
 */
public class PopCornSoda{
    private static final String POPCORN = "POPCORN";
    private static final String SODA = "SODA";
    private static final String BUNDLE = "BUNDLE";
    private final Map<String, Double> prices = new HashMap<>();

    PopCornSoda(){
    }

    public Double calculatePrice(Map<String, String[]> totalItems){
        readPrices();
        return totalItems.keySet().stream().map(perDayAmount(totalItems)).reduce(Double::sum).orElse(0d);
    }

    private void readPrices() {
        prices.put(POPCORN, 7.0);
        prices.put(SODA, 2.5);
        prices.put(BUNDLE, 9.0);
    }

    private Function<String, Double> perDayAmount(Map<String, String[]> inputItems) {
         return
            date -> {
            double amountPerDay;
            int popcorn=0, soda=0;
            for(String item : inputItems.get(date)) {
                if (Objects.equals(item, POPCORN)) {
                    popcorn++;
                } else if (Objects.equals(item, SODA)) {
                    soda++;
                }
            }
            if (popcorn < soda) {
                amountPerDay = (popcorn * prices.get(BUNDLE)) + ((soda - popcorn) * prices.get(SODA));
            } else {
                amountPerDay = (soda * prices.get(BUNDLE)) + ((popcorn - soda) * prices.get(POPCORN));
            }
            return amountPerDay;
        };
    }


    public static void main(String[] args) {
        PopCornSoda ps = new PopCornSoda();
        Map<String, String[]> inputItems = new HashMap<>();
        /*
        inputItems.put("010121", new String[]{POPCORN, SODA, POPCORN, POPCORN, SODA});
        inputItems.put("010221", new String[]{POPCORN, SODA, POPCORN, SODA, SODA});
        inputItems.put("010321", new String[]{POPCORN, SODA, POPCORN, POPCORN, SODA, SODA});
        System.out.println(ps.calculatePrice(inputItems));
        */

        Scanner sc = new Scanner(System.in);
        System.out.println("choose 1 -> Enter Details 0 -> Exit and calculate ");
        while (sc.nextInt() != 0) {
            System.out.println("enter a date");
            String date = sc.next();
            System.out.println("enter list of items comma separated:");
            String items = sc.next();
            inputItems.put(date,  items.split(","));
            System.out.println("choose 1 -> Enter Details 0 -> Exit and calculate ");
        }
        System.out.println(ps.calculatePrice(inputItems));
    }
}

