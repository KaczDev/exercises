package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_518 implements Solution {
    @Override
    public void solve() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println("Solution: " + this.changeMemo(amount, coins));
        System.out.println("Solution: " + this.changeMemoDP(amount, coins));
        System.out.println("Solution: " + this.changeMemoDPOptimizedSpace(amount, coins));
    }

    //O(m*n) Space DP -- most likely the bet solution O(n) takes a bit of thinking
    private int changeMemoDP(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        Arrays.fill(dp[0], 1);
        for (int a = 1; a < amount + 1; a++) {
            for (int i = coins.length - 1; i >= 0; i--) {
                dp[a][i] = dp[a][i + 1];
                if (a - coins[i] >= 0) {
                    dp[a][i] += dp[a - coins[i]][i];
                }
            }
        }
        return dp[amount][0];

    }

    //    O(n) Space DP
    private int changeMemoDPOptimizedSpace(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            int[] nextDP = new int[amount + 1];
            nextDP[0] = 1;
            for (int a = 1; a < amount + 1; a++) {
                nextDP[a] = dp[a];
                if (a - coins[i] >= 0) {
                    nextDP[a] += nextDP[a - coins[i]];
                }
            }
            dp = nextDP;
        }
        return dp[amount];
    }

    //Memoization solution
    private int changeMemo(int amount, int[] coins) {
        Map<int[], Integer> cache = new HashMap<>();
        return this.dfsMemo(coins, amount, 0, 0, cache);

    }

    private int dfsMemo(int[] coins, int amount, int i, int a, Map<int[], Integer> cache) {
        if (a == amount) return 1;
        if (a > amount) return 0;
        if (i == coins.length) return 0;
        if (cache.containsKey(new int[]{i, a})) {
            return cache.get(new int[]{i, a});
        }
        int val = this.dfsMemo(coins, amount, i, a + coins[i], cache) + this.dfsMemo(coins, amount, i + 1, a, cache);
        cache.put(new int[]{i, a}, val);
        return val;
    }


}
