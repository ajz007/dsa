package io.dsa.patterns.slidingwindow.java;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * You can assume that K is less than or equal to the length of the given string.
 *  nums = {1,2,4,5,5,3,4,5,6,7,8,9,8}
 *
 */
public class LongestSubStringWithKDistinctChars {

    public static void main (String args[]) {
        System.out.println("Max Length = "+ findLongestSubStrWithKDistinctChars(new int[]{1,2,4,5,5,3,4,5,6,7,8,9,8}));
    }

    private static int findLongestSubStrWithKDistinctChars(int nums[]) {

        //initialize
        int begin = 0;
        int end = 0 ;
        var charFreq = new HashSet<Integer>();
        int max_length = Integer.MIN_VALUE;

        //slide window based on begin. end resets to begin everytime
        while(end < nums.length) {

            if(!charFreq.add(nums[end])) {
              max_length = Math.max(charFreq.size(), max_length);
              begin++;
              end = begin;
              charFreq = new HashSet<>();
            } else if(end == nums.length)  {
                max_length = Math.max(charFreq.size(), max_length);
                begin++;
                end = begin;
            } else {
                end++;
            }
        }

        return max_length;
    }
}
