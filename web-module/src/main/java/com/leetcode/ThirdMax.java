package com.leetcode;

import java.util.ArrayList;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;

public class ThirdMax {

    public int thirdMax(int[] nums) {
        final ArrayList<Integer> l = new ArrayList<>();
        for (final int i: nums) {
            if (!l.contains(i)) {
                l.add(i);
            }
        }
        sort(l, reverseOrder());
       if (l.size() < 3){
           switch (nums.length){
               case 2 : return Math.max(nums[0], nums[1]);
               case 1 : return nums[0];
           }
       } else {
           return l.get(2);
       }
      return 0;
    }

    public static void main(String[] args) {
        final ThirdMax tm = new ThirdMax();
        System.out.println(tm.thirdMax(new int[]{3,2,3,2,1,4}));
        System.out.println(tm.thirdMax(new int[]{1,2}));
        System.out.println(tm.thirdMax(new int[]{3,2,1}));


    }
}
