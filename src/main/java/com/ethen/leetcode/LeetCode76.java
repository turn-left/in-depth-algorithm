package com.ethen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * @author ethenyang@126.com
 * @since 2022/11/13
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 需要的目标字符及数量
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        // 是否有效
        int valid = 0;
        int left = 0, right = 0;
        // 记录最小子串起始下标及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char rCh = s.charAt(right);
            // 窗口扩大
            right++;
            if (need.containsKey(rCh)) {
                window.put(rCh, window.getOrDefault(rCh, 0) + 1);
                if (need.get(rCh).equals(window.get(rCh))) {
                    valid++;
                }
            }
            // 满足窗口缩小条件
            while (valid == need.size()) {
                // 如果长度有变小则重新计算
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 窗口缩小
                char lCh = s.charAt(left);
                left++;
                // 窗口缩小联动更新
                if (need.containsKey(lCh)) {
                    window.put(lCh, window.get(lCh) - 1);
                    if (window.get(lCh) < need.get(lCh)) {
                        valid--;
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
