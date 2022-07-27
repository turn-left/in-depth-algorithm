package com.ethen.nowcoder.exam;

import java.util.Scanner;

/**
 * 字符串加解密
 *
 * @author ethenyang@126.com
 * @since 2022/07/17
 */
public class HJ29Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plain = scanner.nextLine().trim();
        System.out.println(encrypt(plain));
        String encoded = scanner.nextLine().trim();
        decrypt(encoded);
    }

    private static void decrypt(String source) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char lastChar = lastChar(chars[i]);
            if (isLowercase(chars[i])) {
                System.out.print((char) (lastChar - 32));
            } else if (isUppercase(chars[i])) {
                System.out.print((char) (lastChar + 32));
            } else {
                System.out.print((char)lastChar);
            }
        }
    }

    private static String encrypt(String source) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char next = nextChar(chars[i]);
            if (isUppercase(chars[i])) {
                chars[i] = (char) (next + 32);
            } else if (isLowercase(chars[i])) {
                chars[i] = (char) (next - 32);
            } else {
                chars[i] = next;
            }
        }
        return new String(chars);
    }

    private static char nextChar(char cur) {
        if (cur == '9') {
            return '0';
        } else if (cur == 'Z') {
            return 'A';
        } else if (cur == 'z') {
            return 'a';
        } else {
            return (char) (cur + 1);
        }
    }

    private static char lastChar(char cur) {
        if (cur == '0') {
            return '9';
        } else if (cur == 'a') {
            return 'z';
        } else if (cur == 'A') {
            return 'Z';
        } else {
            return (char) (cur - 1);
        }
    }

    private static boolean isUppercase(char ch) {
        return ch <= 'Z' && ch >= 'A';
    }

    private static boolean isLowercase(char ch) {
        return ch <= 'z' && ch >= 'a';
    }

    private static boolean isNumeric(char ch) {
        return ch < '9' && ch > '0';
    }
}
