package com.vardhan.corejava.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Q5_SubArrays {
    public static void main(String args[]){
        //Reading the array from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array that is to be created: ");
        int size = sc.nextInt();
        int[] myArray = new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<size; i++){
            myArray[i] = sc.nextInt();
        }
        //Reading the number
        System.out.println("Enter the required sum: ");
        int reqSum = sc.nextInt();
        System.out.println("The array created is: "+Arrays.toString(myArray));
        System.out.println("sub arrays whose sum is: "+reqSum);
        for(int i=0; i<myArray.length; i++){
            int sum = 0;
            for (int j=i; j<myArray.length; j++){
                sum = sum + myArray[j];
                if(sum == reqSum){
                    System.out.println(Arrays.toString(Arrays.copyOfRange(myArray, i, j+1)));
                }
            }
        }
    }
}
