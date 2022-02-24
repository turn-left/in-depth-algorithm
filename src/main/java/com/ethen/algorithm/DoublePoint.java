package com.ethen.algorithm;

/**
 * 双指针问题
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E5%8F%8C%E6%8C%87%E9%92
 * %88.md
 *
 * @author ethenyang@126.com
 * @since 2022/02/24
 */
public class DoublePoint {


    /**
     * 题目描述：在有序数组中找出两个数，使它们的和为 target。
     *
     * @param source 有序数组
     * @param target 目标数字
     * @return 两个数的下标
     */
    public int[] twoSum(int[] source, int target) {
        if (source == null || source.length <= 2) return null;

        int i = 0, j = source.length - 1;

        while (i < j) {
            int sum = source[i] + source[j];

            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
