package com.ethen.nowcoder.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * HJ23 删除字符串中出现次数最少的字符
 *
 * @author ethenyang@126.com
 * @since 2022/07/26
 */
public class HJ23Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        statistics(input);
    }

    private static void statistics(String source) {
        char[] chars = source.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : chars) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        Integer min = countMap.values().stream().sorted().findFirst().orElse(0);
        Set<Character> chSet = countMap.entrySet().stream().filter(item -> item.getValue() == min).map(Map.Entry::getKey).collect(Collectors.toSet());
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (chSet.contains(ch)) {
                continue;
            }
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
