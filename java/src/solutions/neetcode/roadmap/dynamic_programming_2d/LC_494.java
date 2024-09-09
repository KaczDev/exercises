package solutions.neetcode.roadmap.dynamic_programming_2d;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_494 implements Solution {
    @Override
    public void solve() {
        int[] nums = new int[5];
        Arrays.fill(nums, 1);
        int target = 3;
        System.out.println("Solution: " + this.findTargetSumWays(nums, target));
    }

    private int findTargetSumWays(int[] nums, int target) {
        // (Index,Total), # of ways
        Map<Pair, Integer> dp = new HashMap<>();
        return this.backtrack(nums, target, dp, 0, 0);
    }

    private int backtrack(int[] nums, int target, Map<Pair, Integer> dp, int i, int total) {
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        Pair p = new Pair(i, total);
        if (dp.containsKey(p)) {
            return dp.get(p);
        }
        int ways = this.backtrack(nums, target, dp, i + 1, total + nums[i])
                + this.backtrack(nums, target, dp, i + 1, total - nums[i]);
        dp.put(p, ways);
        return dp.get(p);
    }

    record Pair(int idx, int t) {
    }
}
