package com.vardhan.corejava.strings;

public class Q2_Anagrams {

    static boolean isAnagram(String a, String b) {

        String sortedA = "";
        Object[] aArr = a.toLowerCase().chars().sorted().mapToObj(i -> (char) i).toArray();
        for (Object o: aArr) {
            sortedA = sortedA.concat(o.toString());
        }

        String sortedB = "";
        Object[] bArr = b.toLowerCase().chars().sorted().mapToObj(i -> (char) i).toArray();
        for (Object o: bArr) {
            sortedB = sortedB.concat(o.toString());
        }

        if(sortedA.equals(sortedB))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String s1 = "Protijayi";
        String s2 = "jayiProti";

        System.out.println("Anagram: " + isAnagram(s1, s2));
    }
}
