package io.dsa.patterns.slidingwindow.java;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Given an array of positive numbers and a positive number S, find the length of the smallest contiguous subarray whose sum is greater than or equal to S.
 *
 * Return 0 if no such subarray exists.
 *
 */
public class SmallestSubArrayWithSum {

    public static void main(String args[]){
        System.out.println("Minimum length = "+ findSmallestSubArray(new int[]{1, 4, 45, 6, 0, 19}, 51));
    }

    private static int findSmallestSubArray(int[] nums, int sum) {
        //intitalize
        int begin = 0;
        int end = 0;
        int current_sum = 0;
        int min_size = Integer.MAX_VALUE;

        //edge
        if(nums == null || nums.length == 0 || sum <=0) return -1;

        //slide only begin and find size of the window with end
        while(end < nums.length) {
            current_sum += nums[end];
            if(current_sum > sum){
                var length = (end - begin) + 1;
                System.out.println("length = "+length);
                min_size = Math.min(min_size, length);
                begin++;
                end = begin;
                current_sum = 0;
            } else {
                end ++;
            }

        }
        return min_size == Integer.MAX_VALUE ? -1 : min_size;
    }
}
