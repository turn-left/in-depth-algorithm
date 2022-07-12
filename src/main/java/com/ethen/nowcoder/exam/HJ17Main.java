package com.ethen.nowcoder.exam;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * HJ17 坐标移动
 * <p>
 * todo 简单java正则表达式练习
 * todo switch case 用法格式
 * <p>
 * https://www.runoob.com/java/java-regular-expressions.html
 *
 * @author ethenyang@126.com
 * @since 2022/07/11
 */
public class HJ17Main {

    private static final String PATTERN = "^[ADWS][0-9]{1,2}$";

    private static boolean isValid(String input) {
        if (input == null || input.trim().equals("")) return false;
        return Pattern.matches(PATTERN, input);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.nextLine().trim();
        int x = 0, y = 0;
        String[] locations = origin.split(";");
        for (String location : locations) {
            if (!isValid(location)) {
                continue;
            }
            // 坐标移动
            String wasd = location.substring(0, 1);
            int num = Integer.parseInt(location.substring(1));
            switch (wasd) {
                case "W":
                    y += num;
                    break;
                case "S":
                    y -= num;
                    break;
                case "A":
                    x -= num;
                    break;
                case "D":
                    x += num;
                    break;
                default:
                    x = +num;
                    break;
            }
        }
        System.out.println(x + "," + y);
    }
}
