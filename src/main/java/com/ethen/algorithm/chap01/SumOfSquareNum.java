package com.ethen.algorithm.chap01;

import java.util.Arrays;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 *
 * @author ethenyang@126.com
 * @since 2022/03/05
 */
public class SumOfSquareNum {

    public static void main(String[] args) {
        long[] result = find(2147483646);
        System.out.println(Arrays.toString(result));
    }


    /**
     * 双指针 fixme暴力解法
     *
     * @param input
     * @return
     */
    public static long[] find(int input) {
        assert input >= 0;

        long head = 0;
        long tail = (long) Math.sqrt(input);

        while (head <= tail) {
            if (head * head + tail * tail == input) {
                long[] result = new long[2];
                result[0] = head;
                result[1] = tail;
                return result;
            } else if (head * head + tail * tail > input) {
                tail--;
            } else {
                head++;
            }
        }
        return null;
    }
}
