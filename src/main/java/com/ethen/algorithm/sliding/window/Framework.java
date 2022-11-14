package com.ethen.algorithm.sliding.window;

import java.util.Map;

/**
 * 滑动窗口算法框架
 *
 * @author ethenyang@126.com
 * @since 2022/11/13
 */
public class Framework {
    public void slidingWindowd(String str) {
        Map<Character, Integer> window;
        int left = 0, right = 0;
        while (right < str.length()) {
            // ch是将移入窗口的字符
            char ch = str.charAt(right);
            // 增大窗口
            right++;
            // todo 进行窗口内数据的一些列更新
            // ...

            // debug输出的位置
            System.out.printf("[%d,%d)", left, right);

            // 判断左侧窗口是否要收缩
            // todo isNeedShrink 实际是一系列条件 此处占位
            boolean isNeedShrink = false;
            while (isNeedShrink) {
                // d是将移出窗口的字符
                char d = str.charAt(left);
                // 缩小窗口
                left++;
                // todo 进行窗口内数据的更新
                // ...
            }
        }
    }
}
