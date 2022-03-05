package com.ethen.algorithm.chap01;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * @author ethenyang@126.com
 * @since 2022/03/05
 */
public class ReverseVowels {

    private static final char[] SEEDS = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

    private static final List<Character> SEED_LIST = new ArrayList<>();

    static {
        for (char seed : SEEDS) {
            SEED_LIST.add(seed);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(reverseWithDoublePoint("hello"));
    }


    private static String reverse(String input) {
        if (input == null || input.trim().length() == 0) {
            return input;
        }

        char[] originChars = input.toCharArray();
        List<Integer> indexList = new ArrayList<>();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < originChars.length; i++) {
            if (SEED_LIST.contains(originChars[i])) {
                characterList.add(originChars[i]);
                indexList.add(i);
            }
        }
        if (characterList.size() == 0) {
            return input;
        }
        for (int i = 0; i < characterList.size() / 2; i++) {
            Character reverseCh = characterList.get(characterList.size() - 1 - i);
            Character currerntCh = characterList.get(i);
            characterList.set(i, reverseCh);
            characterList.set(characterList.size() - 1 - i, currerntCh);
        }
        for (int i = 0; i < indexList.size(); i++) {
            originChars[indexList.get(i)] = characterList.get(i);
        }
        return new String(originChars);
    }

    private static String reverseWithDoublePoint(String input) {
        if (input == null || input.trim().length() == 0) {
            return input;
        }
        char[] originChars = input.toCharArray();
        int i = 0, j = originChars.length - 1;

        while (i < j) {
            if (!SEED_LIST.contains(originChars[i])) {
                i++;
                continue;
            }
            if (!SEED_LIST.contains(originChars[j])) {
                j--;
                continue;
            }
            char tmp = originChars[i];
            originChars[i] = originChars[j];
            originChars[j] = tmp;
            i++;
            j--;
        }
        return new String(originChars);
    }


}
