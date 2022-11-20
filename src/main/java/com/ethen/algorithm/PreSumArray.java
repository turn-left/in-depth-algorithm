package com.ethen.algorithm;

/**
 * 前缀和数组
 * <p>
 * 力扣303. 区域和检索 - 数组不可变
 *
 * @author ethenyang@126.com
 * @since 2022/11/20
 */
public class PreSumArray {

    private final int[] preSum;

    /**
     * 构造前缀和数组
     * preSum[i]表示【0 到 i-1】元素之和
     *
     * @param nums 原数组
     */
    public PreSumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /**
     * 计算数组区间 left 到right的元素之和
     */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
