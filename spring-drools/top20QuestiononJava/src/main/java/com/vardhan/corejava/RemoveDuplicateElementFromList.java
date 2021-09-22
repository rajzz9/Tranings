package com.vardhan.corejava;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateElementFromList {

    public static <T> Set<T> removeDuplicates(Collection<T> input, Comparator<T> comparer) {
        return input.stream().collect(Collectors.toCollection(() -> new TreeSet<>(comparer)));
    }

    public static void main(String[] args) {

        ArrayList<C> input = new ArrayList<C>();
        Collections.addAll(input, new C(7), new C(42), new C(42));
        Collection<C> result = removeDuplicates(input, (c1, c2) -> Integer.compare(c1.value, c2.value));
        System.out.println("2 == " +  result.size());
        System.out.println(result.stream().anyMatch(c -> c.value == 7));
        System.out.println((result.stream().anyMatch(c -> c.value == 42)));

    }

    private static class C {
        public final int value;

        private C(int value) {
            this.value = value;
        }
    }
}
