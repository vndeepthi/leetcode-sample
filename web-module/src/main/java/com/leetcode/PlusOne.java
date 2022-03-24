package com.leetcode;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len-1; i>=0; i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[len+1]; // if all the numbers are 9
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
}
