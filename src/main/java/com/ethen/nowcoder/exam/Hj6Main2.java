package com.ethen.nowcoder.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ6 质数因子
 * <p>
 * 1.查找因数
 * 2.判断质数
 * 3.出现次数
 *
 * @author ethenyang@126.com
 * @since 2022/07/09
 */
public class Hj6Main2 {
    private static List<Integer> primeCache = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bigNum = scanner.nextInt();
        if (isPrime(bigNum)) {
            System.out.println(bigNum);
            return;
        }
        long start = System.currentTimeMillis();
        List<Integer> factors = findFactors(bigNum);
        System.out.println("findFactors cost:" + (System.currentTimeMillis() -start));
        StringBuilder sb = new StringBuilder();
        for (Integer factor : factors) {
            if (!isPrime(factor)) {
                continue;
            }

            while (bigNum % factor == 0) {
                sb.append(factor).append(" ");
                bigNum = bigNum / factor;
            }
        }

        System.out.println(sb.toString().trim() + "\n cost:"+(System.currentTimeMillis() -start));
    }

    /**
     * 查找因数
     *
     * @param bigNum
     * @return
     */
    private static List<Integer> findFactors(int bigNum) {
        List<Integer> factorList = new ArrayList<>();
        for (int k = 2; k <= bigNum; k++) {
            if (bigNum % k == 0) {
                factorList.add(k);
                bigNum = bigNum / k;
            }
            if (isPrime(bigNum)) {
                factorList.add(bigNum);
                break;
            }
        }
        return factorList;
    }

    /**
     * 判断是否为质数
     */
    private static boolean isPrime(int num) {
        if (primeCache.contains(num)) {
            return true;
        }
        if (num < 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        primeCache.add(num);
        return true;
    }

}


