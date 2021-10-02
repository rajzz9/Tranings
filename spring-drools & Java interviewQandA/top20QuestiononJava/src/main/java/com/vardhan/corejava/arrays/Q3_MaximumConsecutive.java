package com.vardhan.corejava.arrays;

public class Q3_MaximumConsecutive {
    // Returns count of maximum consecutive 1's  in binary array arr[0..n-1]
    static int getMaxLength(boolean arr[], int n) {

        int count = 0; //intitialize count
        int result = 0; //initialize max

        for (int i = 0; i < n; i++) {

            // Reset count when 0 is found
            if (arr[i] == false)
                count = 0;
                // If 1 is found, increment count  and update result if count becomes  more.
            else {
                count++;//increase count
                result = Math.max(result, count);
            }
        }

        return result;
    }

    // Driver method
    public static void main(String[] args) {
        boolean arr[] = {true, true, false, false, true, true, true, true,
                false, false, false, false};

        int n = arr.length;

        System.out.println(getMaxLength(arr, n));
    }
}
