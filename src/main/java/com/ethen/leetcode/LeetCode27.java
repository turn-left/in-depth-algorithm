package com.ethen.leetcode;

/**
 * 27. 移除元素
 *
 * @author ethenyang@126.com
 * @since 2022/11/08
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}
