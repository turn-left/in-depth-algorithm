package com.ethen.demo;

import java.util.Arrays;

/**
 * 多维数组计算
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1259544232593792
 *
 * @author ethenyang@126.com
 * @since 2022/11/15
 */
public class MultiArray {
    public static void main(String[] args) {
        int[][] multi = new int[3][];
        multi[0] = new int[]{10, 25, 61};
        multi[1] = new int[]{1, 5, 6};

        System.err.println(Arrays.deepToString(multi));
    }
}
