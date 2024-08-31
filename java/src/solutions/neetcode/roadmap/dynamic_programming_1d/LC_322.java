package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

import java.util.Arrays;

public class LC_322 implements Solution {
    @Override
    public void solve() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Solution: " + this.coinChange(coins, amount));
    }

    // Time: O(amount*coins.length)
    // Space: O(amount)
    private int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int a = 1; a < amount + 1; a++) {
            for (int c : coins) {
                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
