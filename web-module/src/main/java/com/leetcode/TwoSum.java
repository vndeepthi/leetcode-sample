package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i < nums.length; i++){
            for (int j= i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException(" no two sum in the array");
    }
    public String twoSum1(int[] nums, int target) {

        String result = "";
        final HashMap<Integer, Integer> numsWithIndex =  new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nonNull(numsWithIndex.get(target - nums[i]) ) && i != numsWithIndex.get(target - nums[i])){
                result = result + "[" + nums[i] + "," + (target - nums[i]) + "]";
            }
            else {
                numsWithIndex.put(nums[i], i);
            }
        }
        return result;
    }

    public String twoPointer(int[] nums, int target) {
        String result= "";
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(System.out::print);

            int low = 0, high = nums.length-1;
            while (low < nums.length && high > 0) {
                if (nums[low] + nums[high] < target){
                    low++;
                } else if (nums[low] + nums[high] > target){
                    high--;
                } else {
                    System.out.println("[" + nums[low]+ ","+nums[high] + "]");
                    low++;
                    high--;
                    continue;
                }
            }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        //System.out.println(twoSum.twoSum1(new int[]{0, 2, 3,5, 4,5, 6, 7, 8, 9, 10}, 5));
        System.out.println(twoSum.twoPointer(new int[]{0, 2, 3,5, 4,5, 6, 7, 8, 9, 10}, 7));
    }
}
