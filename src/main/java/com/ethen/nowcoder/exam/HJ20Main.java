package com.ethen.nowcoder.exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * HJ20 密码验证合格程序
 *
 * @author ethenyang@126.com
 * @since 2022/07/12
 */
public class HJ20Main {
    private static final String NG = "NG";

    private static final String OK = "OK";

    private static final Set<Character> SPECIAL = new HashSet<>();

    static {
        SPECIAL.add('!');
        SPECIAL.add('@');
        SPECIAL.add('#');
        SPECIAL.add('$');
        SPECIAL.add('%');
        SPECIAL.add('^');
        SPECIAL.add('&');
        SPECIAL.add('*');
        SPECIAL.add('(');
        SPECIAL.add(')');
        SPECIAL.add('-');
        SPECIAL.add('_');
        SPECIAL.add('=');
        SPECIAL.add('+');
        SPECIAL.add('.');
        SPECIAL.add(',');
        SPECIAL.add('?');
        SPECIAL.add(';');
        SPECIAL.add(':');
        SPECIAL.add('"');
        SPECIAL.add('|');
        SPECIAL.add('/');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            judge(input);
        }
        scanner.close();
    }

    private static void judge(String input) {
        // 长度超过8位
        char[] chars = input.toCharArray();
        if (chars.length <= 8) {
            System.out.println(NG);
            return;
        }

        // 是否包含4中3
        int count = 0;
        if (containsLower(chars)) count++;
        if (containsUpper(chars)) count++;
        if (containsNumber(chars)) count++;
        if (containsSpecial(chars)) count++;
        if (count < 3) {
            System.out.println(NG);
            return;
        }

        // 是否有子串
        for (int i = 3; i <= chars.length / 2; i++) {
            // 子串长度为i
            // 从头开始
            for (int j = 0; j < chars.length / 2; j++) {
                String sub = input.substring(j,j+i);
                if (isRepeated(input,sub)) {
                    System.out.println(NG);
                    return;
                }
            }
        }
        System.out.println(OK);
    }

    private static boolean containsUpper(char[] chars) {
        for (char ch : chars) {
            if (ch <= 'Z' && ch >= 'A') {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLower(char[] chars) {
        for (char ch : chars) {
            if (ch <= 'z' && ch >= 'a') {
                return true;
            }
        }
        return false;
    }

    private static boolean containsNumber(char[] chars) {
        for (char ch : chars) {
            if (ch <= '9' && ch >= '0') {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecial(char[] chars) {
        for (char ch : chars) {
            if (SPECIAL.contains(ch)) {
                return true;
            }
        }
        return false;
    }

    // 从2~len/2
    private static boolean isRepeated(String input, String sub) {
        return input.indexOf(sub) != input.lastIndexOf(sub);
    }
}
