package io.dsa.patterns.slidingwindow.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * Given an array, find the average of all contiguous subarrays of size K in it.
 *
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 */
public class AverageOfSubArrays {

    public static void main(String args[]) {
        //System.out.println("Average = "+findAvg(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));
        //System.out.println("Average = "+findingAverageSlidingWindowWithClarity(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5));
        System.out.println("Average = "+findingAverageSlidingWindowWithClarity(new int[]{ 1, 4, 2, 10, 2, 3, 1, 0, 20 }, 4));
    }

    private static int findAvg(int []nums, int k) {
        int begin = 0;
        int end = k-1;
        int sum = 0;
        int prev = 0;
        var list = new ArrayList<Integer>();
        while(end < nums.length) {
            if(sum == 0) {
                sum = (int)IntStream.range(begin, end).mapToLong(i -> nums[i]).sum();
            } else {
                sum = sum - nums[prev];
                sum = sum + nums[end];
            }
            list.add(sum);
            prev = begin;
            begin ++;
            end++;
        }
        return findAvg(list);
    }

    private static int findingAverageSlidingWindowWithClarity(int []nums, int k){

        var list = new ArrayList<Integer>();
        int begin = 0;
        int end = 0;
        int sum = 0;

        if(nums == null || nums.length == 0 || k == 0) return -1;


        //create window and calculate first sum
        while(end < k ){
            sum += nums[end];
            end++;
        }
        list.add(sum);

        //slide window until end
        while(end < nums.length) {
            sum -= nums[begin];
            sum += nums[end];
            begin++;
            end++;
            list.add(sum);
        }

        //get average
        int newSum = (int)list.stream().mapToLong(i -> i).sum();
        return newSum/list.size();
    }

    private static int findAvg(List<Integer> list) {
        int sum = (int) list.stream().mapToLong(i -> i).sum();
        return sum/list.size();
    }

}



