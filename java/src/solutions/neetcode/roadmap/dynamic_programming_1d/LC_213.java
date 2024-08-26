package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

public class LC_213 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.rob(new int[]{2,3,2}));
    }
    // Time: O(n)
    // Space: O(1)
    private int rob(int[] nums) {
        // nums[0] when nums.length==1
        if (nums.length == 1)
            return nums[0];
        //Run the helper when skipping the first house
        //OR run the helper when skipping the last house
        return Math.max(this.helper(1, nums.length, nums),
                this.helper(0, nums.length - 1, nums));
    }

    private int helper(int start, int end, int[] nums) {
        int rob1 = 0, rob2 = 0;
        // [rob1, rob2, n, n+1, ... , n]
        for (int i = start; i < end; i++) {
            int tmp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        return rob2;
    }
}
