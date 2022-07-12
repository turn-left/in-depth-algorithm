package com.ethen.nowcoder.exam;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author ethenyang@126.com
 * @since 2022/07/09
 */
public class HJ8Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine().trim());
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < total; i++) {
            String[] line = scanner.nextLine().trim().split(" ");
            int index = Integer.parseInt(line[0]);
            int value = Integer.parseInt(line[1]);

            Integer originVal = map.getOrDefault(index, 0);
            map.put(index, originVal + value);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey()+ " " + entry.getValue()+"\n");
        }
    }
}
