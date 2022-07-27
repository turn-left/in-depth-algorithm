package com.ethen.nowcoder.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串排序
 *
 * @author ethenyang@126.com
 * @since 2022/07/12
 */
public class HJ26Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        char[] chars = input.toCharArray();
        List<Meta> letterList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (isUpper(chars[i])) {
                Meta meta = new Meta(chars[i], chars[i], i);
                letterList.add(meta);
                indexList.add(i);
            } else if (isLower(chars[i])) {
                Meta meta = new Meta(chars[i], (char) (chars[i] - 32), i);
                letterList.add(meta);
                indexList.add(i);
            }
        }
        Collections.sort(letterList);

        for (int i = 0; i < indexList.size(); i++) {
            int index = indexList.get(i);
            chars[index] = letterList.get(i).originChar;
        }
        System.out.println(new String(chars));
    }

    public static boolean isLower(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isUpper(char ch) {
        return ch >= 'A' && ch <= 'Z';

    }

    private static class Meta implements Comparable<Meta> {
        // 原值
        private char originChar;
        // 转变之后的值
        private char newChar;
        // 原来的数组下标
        private int originIndex;

        public Meta(char originChar, char newChar, int originIndex) {
            this.originChar = originChar;
            this.newChar = newChar;
            this.originIndex = originIndex;
        }

        @Override
        public int compareTo(Meta other) {
            if (other.newChar != this.newChar) return this.newChar - other.newChar;

            return this.originIndex - other.originIndex;
        }

        public char getOriginChar() {
            return originChar;
        }

        public char getNewChar() {
            return newChar;
        }

        public int getOriginIndex() {
            return originIndex;
        }
    }
}
