package com.ethen.nowcoder;

import java.util.*;


public class BM44 {
    private final List<Character> starters = Arrays.asList('(', '[', '{');
    private final List<String> matches = Arrays.asList("()", "[]", "{}");

    /**
     * isValid
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (starters.contains(ch)) {
                stack.push(ch);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            if (isMatch(stack.peek(),ch)) {
                stack.pop();
            }
        }
        return stack.empty();
    }

    private boolean isMatch(char prev, char next) {
        String result = prev + "" + next;
        return matches.contains(result);
    }

    public static void main(String[] args) {
        System.err.println(new BM44().isValid("()"));
    }
}