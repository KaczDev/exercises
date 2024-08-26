package solutions.neetcode.roadmap.greedy;

import solutions.Solution;

import java.util.Arrays;

public class LC_45 implements Solution {
    @Override
    public void solve() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("Solution: " + this.jump(nums));
        nums = new int[]{3, 2, 0, 1, 4};
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("Solution: " + this.jump(nums));
    }
    // Time: O(n)
    private int jump(int[] nums) {
        int jumps = 0;
        int l = 0;
        int r = 0;
        // l and r represent the window of idx that we can jump
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps += 1;
        }
        return jumps;
    }
}
