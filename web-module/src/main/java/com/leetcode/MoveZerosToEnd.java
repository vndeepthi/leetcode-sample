package com.leetcode;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        final int[] values = {0,1,2,0,5,0,7};
        moveZerosToEnd(values);
        moveZerosToFront(values);
    }

    private static void moveZerosToFront(final int[] values) {
        reverseArray(values);
    }

    private static void reverseArray(final int[] values) {
        int temp;
        for (int i = 0; i < values.length /2; i++) {
            temp = values[i];
            values[i] = values[values.length-i-1];
            values[values.length-i-1] = temp;
        }
        for (int y: values) {
            System.out.println(y);
        }
    }

    private static int[] moveZerosToEnd(final int[] values) {
        int count = 0;
        final int listSize = values.length;
        for (int i = 0; i < listSize; i++) {
            if(values[i] != 0){
                values[count] = values[i];
                count++;
            }
        }
        for (int i = count; i < listSize; i++) {
            values[i] = 0;
        }
        /*for (int y: values) {
            System.out.println(y);
        }*/
        return values;
    }
}
