package solutions.neetcode.roadmap.greedy;

import solutions.Solution;

import java.util.Arrays;

public class LC_55 implements Solution {
    @Override
    public void solve() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("Solution: " + this.canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("Solution: " + this.canJump(nums));
    }

    private boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = goal - 1; i >= 0; i--) {
            // If we can move from the ith position to goal
            // we shift the goal closer to the beginning
            System.out.printf("GoalBefore: %d, i: %d, nums[i]: %d canReachGoal: %b %n", goal, i, nums[i], i + nums[i] >= goal);
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        // if we reached the beginning.
        return goal == 0;
    }
}
