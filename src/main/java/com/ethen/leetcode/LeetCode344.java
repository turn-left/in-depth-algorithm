package com.ethen.leetcode;

class LeetCode344 {
    /**
     * 344. 反转字符串
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}