package solutions.neetcode.roadmap.stacks;

import solutions.Solution;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/description/
public class LC_155 implements Solution {
    @Override
    public void solve() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    class MinStack {

        private final Stack<Integer> stack;
        private final Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            this.stack.push(val);
            if (!this.minStack.isEmpty()) {
                val = Math.min(val, this.minStack.peek());
            }
            this.minStack.push(val);

        }

        public void pop() {
            this.stack.pop();
            this.minStack.pop();
        }

        public int top() {
            return this.stack.peek();
        }

        public int getMin() {
            return this.minStack.peek();
        }
    }
}
