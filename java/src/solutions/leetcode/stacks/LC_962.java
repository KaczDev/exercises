package solutions.leetcode.stacks;

import solutions.Solution;

import java.util.Stack;

public class LC_962 implements Solution {
    @Override
    public void solve() {
        int[] nums = {6, 0, 8, 2, 1, 5};
        System.out.println("Solution: " + this.maxWidthRamp(nums));
        nums = new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        System.out.println("Solution: " + this.maxWidthRamp(nums));
    }

    private int maxWidthRamp(int[] nums) {
        Stack<Integer> indicesStack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (indicesStack.isEmpty() || nums[indicesStack.peek()] > nums[i]) {
                indicesStack.push(i);
            }
        }
        int max = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[j]) {
                max = Math.max(max, j - indicesStack.peek());
                indicesStack.pop();
            }
        }
        return max;
    }
}
