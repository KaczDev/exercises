package solutions.leetcode.stacks;

import solutions.Solution;

public class LC_1381 implements Solution {
    @Override
    public void solve() {
        CustomStack cs = new CustomStack(3);
        cs.push(1);
        cs.push(2);
        System.out.println(cs.pop());
        cs.push(2);
        cs.push(3);
        cs.push(4);
        cs.increment(5, 100);
        cs.increment(2, 100);
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
    }

    class CustomStack {
        int[] stack;
        int idx;
        int size;

        public CustomStack(int maxSize) {
            this.size = maxSize;
            this.idx = 0;
            this.stack = new int[maxSize];
        }

        public void push(int x) {
            if (idx < size) {
                stack[idx] = x;
                idx += 1;
            }
        }

        public int pop() {
            if (idx == 0) {
                return -1;
            }
            idx -= 1;
            int value = stack[idx];
            stack[idx] = 0;
            return value;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k && i < idx; i++) {
                this.stack[i] += val;
            }
        }
    }
}
