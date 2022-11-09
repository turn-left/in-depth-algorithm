package com.ethen.leetcode;

/**
 * 26. 删除有序数组中的重复项
 * <p>
 * 快慢指针
 */
class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}