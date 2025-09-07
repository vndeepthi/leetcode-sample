package com.leetcode.twopointer;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums == null || nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }
        while (left < nums.length - 1 && nums[left + 1] < 0 ) {
            left++;
        }
        int right = left + 1;
        int[] result = new int[nums.length];
        int resultIndex = 0;
        while (left >=0 && right < nums.length) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[resultIndex++] = rightSquare;
                right++;
            } else {
                result[resultIndex++] = leftSquare;
                left--;
            }
        }
        while (left >=0 && left < nums.length) {
            result[resultIndex++] = nums[left] * nums[left];
            left--;
        }
        while (right < nums.length) {
            result[resultIndex++] = nums[right] * nums[right];
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
        //System.out.println(Arrays.toString(sortedSquares(new int[]{-5,-3,-2,-1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-1,2,2})));

        //System.out.println(Arrays.toString(sortedSquares(new int[]{-1,0, 1})));
    }
}

