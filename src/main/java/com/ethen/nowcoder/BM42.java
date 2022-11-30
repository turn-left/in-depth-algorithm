package com.ethen.nowcoder;

import java.util.Stack;

public class BM42 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        BM42 solution = new BM42();
        solution.push(1);
        solution.push(2);
        System.err.println(solution.pop());
        System.err.println(solution.pop());
    }
}
