package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

import java.util.PriorityQueue;

public class LC_198 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.rob(new int[]{1, 2, 3, 1}));
    }

    private int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        // [rob1, rob2, n, n+1, ...]
        for (int n : nums) {
            int tmp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        return rob2;
    }
}
