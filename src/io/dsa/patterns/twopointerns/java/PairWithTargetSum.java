package io.dsa.patterns.twopointerns.java;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 *
 */
public class PairWithTargetSum {

    public static void main(String args[]){

        //int target = 9;
        //int[] nums = {2,7,11,15};
        // int[] expected = {0,1};
        int[] nums = {3,2,4};
        int target = 6;
        int[] expected = {1,2};

        var resp = findPair(target, nums);
        Arrays.stream(resp).forEach(item -> System.out.println("index ="+ item));
        System.out.println("Result is as expected = "+compare(expected, resp));

    }

    private static int[] findPair(int target, int[] arr) {

        int start =0;
        int end = arr.length - 1;
        int sum = 0;
        while(start < end) {
            sum = arr[start] + arr[end];
            if(target == sum) {
                return new int[] {start, end };
            } else if( sum > target) {
                end --;
            } else {
                start++;
            }
        }
        return new int[0];
    }

    private static Boolean compare(int[] expected, int[] actual){
        return IntStream.range(0, actual.length).mapToObj(i -> actual[i] == expected[i])
                .collect(Collectors.toList())
                .stream()
                .map(data -> {System.out.println(data); return data; })
                .allMatch(data -> data.booleanValue() == true);
    }
}
