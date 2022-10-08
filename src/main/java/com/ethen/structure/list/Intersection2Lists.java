package com.ethen.structure.list;

/**
 * 找出两个链表的交点
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 *
 * @author ethenyang@126.com
 * @since 2022/10/08
 */
public class Intersection2Lists {
    public static void main(String[] args) {
        System.err.println(null == null);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode posA = headA;
        ListNode posB = headB;

        // 只要一个链表为空则不能相交
        if (posA == null || posB == null) {
            return null;
        }
        while (posA != posB) {
            // 指针移动,移动到端节点,切换指针
            posA = posA == null ? headB : posA.next;
            posB = posB == null ? headA : posB.next;
        }
        return posA;
    }
}
