package solutions.leetcode.stacks;

import solutions.Solution;

import java.util.Arrays;
import java.util.Stack;

public class LC_739 implements Solution {
    @Override
    public void solve() {
        int[] temps1 = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] temps2 = new int[]{30, 40, 50, 60};
        int[] temps3 = new int[]{30, 60, 90};
        System.out.println("Solution: " + Arrays.toString(this.dailyTemperatures(temps1)));
        System.out.println("Solution: " + Arrays.toString(this.dailyTemperatures(temps2)));
        System.out.println("Solution: " + Arrays.toString(this.dailyTemperatures(temps3)));
    }

    record Pair(int temp, int idx) {}
    // Time: O(n)
    // Space: O(n)
    private int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek().temp < temp) {
                Pair p = stack.pop();
                res[p.idx] = i - p.idx;
            }
            stack.push(new Pair(temp, i));
        }

        return res;
    }
}
