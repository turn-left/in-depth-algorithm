package com.ethen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 151. 反转字符串中的单词
 *
 * @author ethenyang@126.com
 * @since 2022/11/24
 */
public class LeetCode151 {

    public static void main(String[] args) {
        String source = "the sky is blue";
        String source2 = "  hello world  ";
        String source3 = "a good   example";
        LeetCode151 leetCode151 = new LeetCode151();
        String result = leetCode151.reverseWords(source3);
        System.err.println(result);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String reverseStr = reverse(s);


        String[] splitArray = reverseStr.split(" ");
        List<String> result = new ArrayList<>();
        for (String item : splitArray) {
            if (item.trim().length() == 0) {
                continue;
            }
            result.add(reverse(item));
        }
        return String.join(" ", result);
    }

    private String reverse(String input) {
        char[] chars = input.trim().toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
