package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

import java.util.Arrays;

public class LC_312 implements Solution {
    @Override
    public void solve() {
        int[] nums = {3, 1, 5, 8};
        System.out.println("Solution: " + this.maxCoins(nums));
        nums = new int[]{1, 5};
        System.out.println("Solution: " + this.maxCoins(nums));
    }

    // Time: O(n^3), there are n^2 subarrays and we have to iterate over every value
    // - n.
    // Space: O(n^2)
    private int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int[] r : dp) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        int[] newNums = new int[nums.length + 2];
        newNums[0] = newNums[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        nums = newNums;
        return this.dfs(nums, dp, 1, nums.length - 2);
    }

    private int dfs(int[] nums, int[][] dp, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != Integer.MAX_VALUE) {
            return dp[l][r];
        }
        dp[l][r] = 0;
        for (int i = l; i < r + 1; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, dp, l, i - 1) + dfs(nums, dp, i + 1, r);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }


}
