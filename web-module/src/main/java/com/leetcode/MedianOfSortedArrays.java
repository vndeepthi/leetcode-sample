package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*List<Integer> fullNums = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            fullNums.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            fullNums.add(nums2[i]);
        }*/
        List<Integer> sortedList = null;//mergeSortedArrays(nums1, nums2);
        //List<Integer> sortedList = fullNums.stream().sorted().collect(Collectors.toList ());
        System.out.println("sortedList" + sortedList);
        if (sortedList.size() % 2 == 0) {
            int index = sortedList.size() / 2;
            return  ((sortedList.get(index) + sortedList.get(index - 1)) /2.0) ;
        } else {
            return sortedList.get(sortedList.size() / 2);
        }
    }

    /*private List<Integer> mergeSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> fullNums = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            fullNums.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            fullNums.add(nums2[i]);
        }
    }*/

    public static void main(String[] args) {
        MedianOfSortedArrays obj = new MedianOfSortedArrays();
        System.out.println(obj.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(obj.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        System.out.println(obj.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(obj.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

}
