package com.vardhan.corejava.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q7_MissingNumber {

    public static void main(String[] args)
    {
        int[] a = { 1, 2, 4, 5, 6 };
        //System.out.println(findDisappearedNumbers(a));

        int n = a.length + 1;
        int miss = getMissingNo(a, n);
        System.out.print(miss);
    }


    // getMissingNo function for finding missing number
    static int getMissingNo(int a[], int n)
    {
        int n_elements_sum = n * (n + 1) / 2;
        int sum = 0;

        for(int i = 0; i < n - 1; i++)
            sum += a[i];

        return n_elements_sum - sum;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums)
    {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
