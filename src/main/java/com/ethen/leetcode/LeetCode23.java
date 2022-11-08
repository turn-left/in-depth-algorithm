package com.ethen.leetcode;

import com.ethen.leetcode.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        // 最小优先级队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            // 弹出最小元素
            ListNode minNode = pq.poll();
            res.next = minNode;
            // 移动指针后的链表重新入队
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
            // 结果链表指针向后移动
            res = res.next;
        }
        return dummy.next;
    }
}

