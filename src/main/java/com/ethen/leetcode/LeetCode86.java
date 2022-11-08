package com.ethen.leetcode;

/**
 * 86. 分隔链表
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lsDummy = new ListNode(-1);
        ListNode gtDummy = new ListNode(-1);
        ListNode lt = lsDummy;
        ListNode gt = gtDummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val >= x) {
                gt.next = cur;
                // 指针前移
                gt = gt.next;
            } else {
                lt.next = cur;
                // 指针前移
                lt = lt.next;
            }
            // 断开原节点指针(important)
            ListNode temp = cur.next;
            cur.next = null;
            // 指针前移
            cur = temp;
        }
        lt.next = gtDummy.next;
        return lsDummy.next;
    }

    static class ListNode {
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