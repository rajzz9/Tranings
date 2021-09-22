package com.vardhan.corejava.strings;

/**
 * Input : str = “abc”
 * Output : 6
 * Every substring of the given string : “a”, “b”, “c”, “ab”, “bc”, “abc”
 *
 * Input : str = “abcd”
 * Output : 10
 * Every substring of the given string : “a”, “b”, “c”, “d”, “ab”, “bc”, “cd”, “abc”, “bcd” and “abcd”
 *
 * Count of non-empty substrings is n*(n+1)/2
 * If we include empty string also as substring, the count becomes n*(n+1)/2 + 1
 */
public class Q4_SubStrings {
    static int countNonEmptySubstr(String str)
    {
        int n = str.length();
        return n * (n + 1) / 2;
    }

    // Driver code
    public static void main(String args[])
    {
        String s = "abcde";
        System.out.println(
                countNonEmptySubstr(s));
    }
}
