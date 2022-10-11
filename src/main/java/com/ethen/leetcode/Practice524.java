package com.ethen.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * fixme 待调试
 *
 * @author ethenyang@126.com
 * @since 2022/10/11
 */
public class Practice524 {

    private static final String EMPTY = "";

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        inputList.add("ale");
        inputList.add("apple");
        inputList.add("monkey");
        inputList.add("plea");
        System.err.println(findLongestWord("abpcplea",inputList));
    }


    public static String findLongestWord(String source, List<String> dictionary) {
        if (source == null || EMPTY.equals(source.trim()) || dictionary == null) {
            return EMPTY;
        }
        int sourceLen = source.length();
        PriorityQueue<String> resultQueue = new PriorityQueue<>((prev, next) -> {
            return next.length() - prev.length();
        });


        for (String str : dictionary) {
            if (str == null || str.trim().length() == 0) {
                continue;
            }
            if (str.length() > sourceLen) {
                continue;
            }
            // 判断是否为符合条件的子串
            int cursor = 0;
            for (int i = 0; i < str.length(); ) {
                char charAtI = str.charAt(i);
                for (int j = cursor; j < sourceLen; j++) {
                    if (charAtI == source.charAt(j)) {
                        i++;
                        j++;
                        cursor = j;
                        break;
                    }
                }
                if (i >= str.length()) {
                    resultQueue.add(str);
                } else {
                    break;
                }
            }
        }
        return resultQueue.poll();
    }
}
