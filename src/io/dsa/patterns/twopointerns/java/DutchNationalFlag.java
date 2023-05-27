//package io.dsa.patterns.twopointerns.java;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
///**
// * Input: nums = [2,0,2,1,1,0]
// * Output: [0,0,1,1,2,2]
// */
//
//public class DutchNationalFlag {
//
//    public static void main(String args[]){
//
//
//    }
//
//    private static int[] sortArr(int[] arr){
//        int begin = 0;
//        int end = arr.length -1;
//
//        while(begin < end ) {
//            if(arr[end] < arr[begin]) {
//
//            }
//        }
//    }
//
//    private static Boolean compare(int[] expected, int[] actual){
//        return IntStream.range(0, actual.length).mapToObj(i -> actual[i] == expected[i])
//                .collect(Collectors.toList())
//                .stream()
//                .map(data -> {System.out.println(data); return data; })
//                .allMatch(data -> data.booleanValue() == true);
//    }
//
//}
