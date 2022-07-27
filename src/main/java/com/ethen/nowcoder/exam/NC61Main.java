package com.ethen.nowcoder.exam;

import java.util.Scanner;

/**
 * @author ethenyang@126.com
 * @since 2022/07/26
 */
public class NC61Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String trim = scanner.nextLine().trim();
        String[] split = trim.split(",");
        int target = Integer.parseInt(split[split.length - 1]);
        int[] nums = new int[split.length - 1];
        nums[0] = Integer.parseInt(split[0].replace("[", ""));
        for (int i = 1; i < split.length - 2; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        nums[split.length - 2] = Integer.parseInt(split[split.length - 2].replace("]", ""));
        int[] result = sumTwo(nums, target);
        if (result != null)
            System.out.print(String.format("[%d,%d]", result[0], result[1]));
    }

    public static int[] sumTwo(int[] inputArray, int target) {
        for (int i = 0; i < inputArray.length; i++) {
            int prev = inputArray[i];
            if (prev >= target) {
                continue;
            }
            for (int j = i + 1; j < inputArray.length; j++) {
                int next = inputArray[j];
                if (prev + next == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }
}
