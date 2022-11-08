package com.ethen.leetcode;

/**
 * 21. 合并两个有序链表
 *
 * <a href='https://leetcode.cn/problems/merge-two-sorted-lists/'>力扣21题</a>
 *
 * @author ethenyang@126.com
 * @since 2022/11/07
 */
public class Practice21 {
    public static void main(String[] args) {


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1), result = dummy;

        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                result.next = p2;
                p2 = p2.next;
            } else {
                result.next = p1;
                p1 = p1.next;
            }
            // 指针向前移动
            result = result.next;
        }
        // 有一个链表已经结束
        if (p1 == null) {
            result.next = p2;
        }
        if (p2 == null) {
            result.next = p1;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
