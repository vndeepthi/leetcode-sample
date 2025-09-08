package com.leetcode.twopointer;

/**
 * Given n non-negative integers representing an elevation map where the
 * width of each bar is 1, compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int [] leftMax = new int[height.length];
        int [] rightMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0){
                leftMax[i] = height[i];
                rightMax[height.length-1] = height[height.length-1];
            } else {
                leftMax[i] = Math.max(leftMax[i-1], height[i]);
                rightMax[height.length-i-1] = Math.max(rightMax[height.length-i], height[height.length-i-1]);
            }
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans = ans + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
