package solutions.neetcode.roadmap.greedy;

import solutions.Solution;


public class LC_53 implements Solution {
    @Override
    public void solve() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Solution: " + this.maxSubArray(nums));
    }

    private int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = 0;
        for (int n : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            max = Math.max(max, curSum);
        }
        return max;
    }
}
