package com.ethen.leetcode;

/**
 * 5. 最长回文子串
 */
class LeetCode5 {
    public static void main(String[] args) {
        LeetCode5 solution = new LeetCode5();
        String res = solution.longestPalindrome("a");
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i <= s.length() - 1; i++) {
            String doublePoint = findWithDoublePoint(s, i, i + 1);
            String single = findWithSinglePoint(s, i);
            if (res.length() < doublePoint.length()) {
                res = doublePoint;
            }
            if (res.length() < single.length()) {
                res = single;
            }
        }
        return res;
    }

    // 一个中心点
    private String findWithSinglePoint(String s, int point) {
        int left = point;
        int right = point;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    // 两个中心点
    private String findWithDoublePoint(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}