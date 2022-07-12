package com.ethen.nowcoder.exam;

import java.util.Scanner;

/**
 * HJ6 质数因子
 *
 * @author ethenyang@126.com
 * @since 2022/07/09
 */
public class Hj6Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bigNum = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int k = 2; k <= bigNum; k++) {
            if (!isPrime(k)) {
                System.out.println("current:"+k);
                continue;
            }
            while (isPrimeFactor(bigNum, k)) {
                sb.append(k).append(" ");
                bigNum = bigNum / k;
            }
        }
        System.out.print(sb.toString().trim());
    }


    private static boolean isPrimeFactor(int bigNum, int smallNum) {
        return (bigNum % smallNum == 0);
    }


    // 判断是否为质数
    private static boolean isPrime(int num) {
        if (num < 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


