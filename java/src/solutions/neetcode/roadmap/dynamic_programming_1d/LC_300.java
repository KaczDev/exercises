package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

import java.util.Arrays;

public class LC_300 implements Solution {
    @Override
    public void solve() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Solution: " + this.lengthOfLIS(nums));
    }

    // Time: O(n^2)
    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = nums.length; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(1);
    }
}
