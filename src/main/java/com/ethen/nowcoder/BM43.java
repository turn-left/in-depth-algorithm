package com.ethen.nowcoder;

import java.util.Stack;

public class BM43 {
    private final Stack<Integer> stack = new Stack<>();

    private final Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.empty()) {
            minStack.push(node);
        }
        minStack.push(Math.min(minStack.peek(), node));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
