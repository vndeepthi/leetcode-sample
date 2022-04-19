package com.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 */
public class Inventory {
/*    private static final String POPCORN = "POPCORN";
    private static final String SODA = "SODA";
    private static final String BUNDLE = "BUNDLE";
    private final Map<String, Double> prices = new HashMap<>();

    Inventory(){
    }

    public List<String> listCities(Map<String, String[]> inventory){
        readInventory();
        return inventory.keySet().stream().map(hasAllItems(inventory)).filter(c -> !c.equals("NO")).collect(Collectors.toList());
    }

    private void readPrices() {
        prices.put(POPCORN, 7.0);
        prices.put(SODA, 2.5);
        prices.put(BUNDLE, 9.0);
    }

    private Function<String, String> hasAllItems(Map<String, String[]> inventory) {
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
        Inventory ps = new Inventory();
        Map<String, String[]> inputItems = new HashMap<>();

        inputItems.put("Montreal", new String[]{3, 4, 5});
        inputItems.put("Toronto", new String[]{POPCORN, SODA, POPCORN, SODA, SODA});
        inputItems.put("CCC", new String[]{POPCORN, SODA, POPCORN, POPCORN, SODA, SODA});
        System.out.println(ps.calculatePrice(inputItems));

        *//*Scanner sc = new Scanner(System.in);
        System.out.println("choose 1 -> Enter Details 0 -> Exit and calculate ");
        while (sc.nextInt() != 0) {
            System.out.println("enter a date");
            String date = sc.next();
            System.out.println("enter list of items comma separated:");
            String items = sc.next();
            inputItems.put(date,  items.split(","));
            System.out.println("choose 1 -> Enter Details 0 -> Exit and calculate ");
        }*//*
        System.out.println(ps.calculatePrice(inputItems));
    }*/
}

