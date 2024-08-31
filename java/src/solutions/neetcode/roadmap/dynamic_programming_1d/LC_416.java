package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_416 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.canPartition(new int[]{1, 5, 11, 5}));
    }

    private boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = sum / 2;
        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                nextDp.add(t + nums[i]);
                nextDp.add(t);
            }
            dp = nextDp;
        }
        return dp.contains(target);
    }
}
