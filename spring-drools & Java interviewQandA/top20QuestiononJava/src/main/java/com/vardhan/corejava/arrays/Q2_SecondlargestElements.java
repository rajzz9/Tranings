package com.vardhan.corejava.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_SecondlargestElements {

    public static void main(String[] args) {
//        int[] array = { 1, 2, 3, -1, -2, 4 };
//        Arrays.sort(array);
//        System.out.println(array[array.length-2]);
        int temp, size;
        int array[] = {10, 20, 25, 63, 96, 57};
        size = array.length;

        for(int i = 0; i<size; i++ ){
            for(int j = i+1; j<size; j++){

                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Third second largest number is:: "+array[size-2]);
    }


}


