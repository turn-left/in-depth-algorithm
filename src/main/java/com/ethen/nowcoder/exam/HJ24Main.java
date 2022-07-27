package com.ethen.nowcoder.exam;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * HJ24 合唱队
 *
 * @author ethenyang@126.com
 * @since 2022/07/17
 */
public class HJ24Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        LinkedList<Integer> sourceList = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            sourceList.add(scanner.nextInt());
        }
        // 从大到小遍历，找到最大严格递减队列
        List<Integer> resultList = new LinkedList<>();
        for (int k = 1; k < sourceList.size() - 1; k++) {
            int maxSeqByAnchor = findMaxSeqByAnchor(sourceList, k);
            resultList.add(maxSeqByAnchor);
        }
        int out = sourceList.size() - 1 - Collections.max(resultList);
        System.out.println(out);

    }

    private static int findMaxSeqByAnchor(LinkedList<Integer> source, Integer anchorIndex) {
        int size = source.size();
        if (anchorIndex <= 0 || anchorIndex == size - 1) {
            return 0;
        }
        // 右边
        int rightSide = findLeftSide(source, anchorIndex);
        // 左边
        Collections.reverse(source);
        int leftSide = findRightSide(source, anchorIndex);
        return leftSide + rightSide;
    }

    private static int findLeftSide(LinkedList<Integer> source, Integer anchorIndex) {
        int size = source.size();
        int anchor = source.get(anchorIndex);
        List<Integer> resultList = new LinkedList<>();
        // 根据锚点截取子序列
        // 去掉大的数字
        List<Integer> validList =
                source.subList(anchorIndex, size).stream().filter(item -> item >= anchor).collect(Collectors.toList());
        // 遍历寻找子序列
        if (validList.size() == 0) return 0;
        for (int i = validList.size() - 1; i > 0; i--) {
            // 算第i个数的子序列个数
            int count = 0;
            int cur = validList.get(i);
            for (int j = validList.size() - 1; j > i; j--) {
                Integer num = validList.get(j);
                if (num < cur) {
                    count++;
                    cur = num;
                }
            }
            resultList.add(count);
        }
        // 寻求最大序列数
        return Collections.max(resultList);
    }

    private static int findRightSide(LinkedList<Integer> source, Integer anchorIndex) {
        int size = source.size();
        if (anchorIndex <= 0 || anchorIndex == size - 1) {
            return 0;
        }
        int anchor = source.get(anchorIndex);
        List<Integer> resultList = new LinkedList<>();
        // 根据锚点截取子序列
        // 去掉大的数字
        List<Integer> validList =
                source.subList(anchorIndex, size).stream().filter(item -> item >= anchor).collect(Collectors.toList());
        // 遍历寻找子序列
        if (validList.size() == 0) return 0;
        for (int i = 0; i < validList.size(); i++) {
            // 算第i个数的子序列个数
            int count = 0;
            int cur = validList.get(i);
            for (int j = i; j < validList.size(); j++) {
                Integer num = validList.get(j);
                if (num < cur) {
                    count++;
                    cur = num;
                }
            }
            resultList.add(count);
        }
        // 寻求最大序列数
        return Collections.max(resultList);
    }
}
