package com.ethen.nowcoder.exam;

import java.util.Scanner;

/**
 * 取近似值
 *
 * @author ethenyang@126.com
 * @since 2022/07/09
 */
public class HJ7Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();
        System.err.println(Math.round(value));
    }
}
