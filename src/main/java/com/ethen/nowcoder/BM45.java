package com.ethen.nowcoder;

import java.util.*;

/**
 * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
 */
public class BM45 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0 || num.length < size) {
            return result;
        }
        int left = 0;
        int right = size - 1;
        while (right < num.length) {
            result.add(findMax(num, left, right));
            left++;
            right++;
        }
        return result;
    }

    private int findMax(int[] num, int left, int right) {
        int max = num[left];
        for (int i = left; i <= right; i++) {
            max = Math.max(num[i], max);
        }
        return max;
    }
}
