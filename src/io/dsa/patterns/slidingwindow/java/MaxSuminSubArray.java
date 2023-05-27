package io.dsa.patterns.slidingwindow.java;

/**
 * Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
 *
 * Input  : arr[] = {100, 200, 300, 400}, k = 2
 * Output : 700
 *
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
 * Output : 39
 * We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.
 */
public class MaxSuminSubArray {

    public static void main(String args[]){
        System.out.println("Max sum = "+ findSubArrayWithMaxSum(new int[]{100, 200, 300, 400}, 2));
        //System.out.println("Max sum = "+ findSubArrayWithMaxSum(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4));
    }

    public static int findSubArrayWithMaxSum(int nums[], int k) {

        //initialize
        int begin = 0;
        int end = 0;
        int max_sum = -1;
        int sum = 0;

        //create window and intial sum
        while(end < k) {
            sum += nums[end];
            end ++;
        }

        max_sum = Math.max(sum, max_sum);

        //slide window and get max_sum for each slide

        while(end < nums.length) {
            sum -= nums[begin];
            sum += nums[end];
            begin++;
            end++;
            max_sum = Math.max(sum, max_sum);
        }

        return max_sum;
    }
}
