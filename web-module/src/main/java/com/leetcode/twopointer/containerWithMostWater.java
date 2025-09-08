package com.leetcode.twopointer;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class containerWithMostWater {
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0; int maxHeight = 0, maxArea = 0, currArea = 0;
        int right = height.length - 1;
        while (left <  right ) {
            currArea = (right - left) * (Math.min(height[right], height[left]));
            maxArea = Math.max(maxArea, currArea);
            if  (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 9, 3, 7}));
    }
}
