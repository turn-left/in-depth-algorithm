package com.ethen.demo;

import com.ethen.leetcode.model.ListNode;

import java.util.PriorityQueue;

/**
 * 优先级队列使用demo
 *
 * @author ethenyang@126.com
 * @since 2022/11/08
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        // 最小 优先级队列(升序)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);

        pq.add(new ListNode(10));
        pq.add(new ListNode(5));
        pq.add(new ListNode(110));
        pq.add(new ListNode(-6));

        System.err.println(pq.poll());
        System.err.println(pq.poll());
        System.err.println(pq.poll());
        System.err.println(pq.poll());
        System.err.println(pq.poll());
    }
}
