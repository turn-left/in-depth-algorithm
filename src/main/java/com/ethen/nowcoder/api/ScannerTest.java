package com.ethen.nowcoder.api;

import java.util.Scanner;

/**
 * Scanner API 分析
 * <p>
 * next()方法会以空格作为有效输入的分隔符
 * nextLine()则以换行分隔
 *
 * @author ethenyang@126.com
 * @since 2022/07/09
 */
public class ScannerTest {
    public static void main(String[] args) {
        System.out.print("请输入：");
        Scanner scanner = new Scanner(System.in);
        // hasNext() 返回false时会阻塞等待输入
//        if (scanner.hasNext()) {
//            System.err.println(scanner.next());
//        }
        // 会阻塞等待输入
//        System.out.println("next()-->" + scanner.next());
        System.out.println("nextLine()-->" + scanner.nextLine());
        System.err.println("#########################end##########################");
    }
}
