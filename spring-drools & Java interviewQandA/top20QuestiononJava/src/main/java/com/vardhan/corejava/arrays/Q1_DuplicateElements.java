package com.vardhan.corejava.arrays;

import java.util.Arrays;

public class Q1_DuplicateElements {

    /*
     *   Q1: Write a java program to find duplicate elements in an array?
     */
    public static void main(String[] args) {
        int[] numArray = {8, 1, 7, 6, 2, 19, 1, 19};
        findDuplicates(numArray);
    }


    static void findDuplicates(int arr[]) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                System.out.println("Duplicate element found " + arr[i]);
            }
        }
    }
}
