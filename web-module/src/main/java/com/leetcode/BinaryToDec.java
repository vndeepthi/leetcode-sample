package com.leetcode;

import java.util.*;

public class BinaryToDec {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String n1=s.nextLine();
        String[] values = n1.split(" ");

        int countOfSocks=0;
        List<String> socksPail = new LinkedList<>();
        for (String r: values  ) {
            if(socksPail.contains(r)) {
                socksPail.remove(r);
                countOfSocks++;
            } else {
                socksPail.add(r);
            }
        }
        System.out.println("countOfSocks" + countOfSocks);
    }
}
