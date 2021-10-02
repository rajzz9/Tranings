package com.vardhan.corejava.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q3_BlancedBrackets {
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            } else if(!stack.empty() && map.get(stack.peek())==c){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String input="(a{[d]}b)";
        System.out.println(isValid(input));
    }
}
