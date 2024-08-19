package solutions.leetcode.dynamic_programming;

import solutions.Solution;

public class LC_650 implements Solution {
    @Override
    public void solve() {
        System.out.println(this.minSteps(3));
    }

    private int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 1; j < (i / 2); j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                }
            }
        }
        return dp[n];
    }
}
