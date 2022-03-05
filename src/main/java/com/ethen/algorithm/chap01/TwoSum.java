package com.ethen.algorithm.chap01;

/**
 * 双指针问题
 * <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和
 * numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * @author ethenyang@126.com
 * @since 2022/02/24
 */
public class TwoSum {


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
