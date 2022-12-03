package com.ethen.nowcoder;

import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 */
public class BM46 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        int len = input.length;

        if (k >= len) {
            for (int num : input) {
                res.add(num);
            }
            return res;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : input) {
            pq.add(num);
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }

}