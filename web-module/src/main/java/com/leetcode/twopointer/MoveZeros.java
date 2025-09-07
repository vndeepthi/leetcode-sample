package com.leetcode.twopointer;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeros {

    public static void moveZeroes(int[] nums) {
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{1, 3, 12, 0});
        moveZeroes(new int[]{0, 1, 0, 3, 12, 0, 1});
    }
}
