package solutions.leetcode.heaps;

import solutions.Solution;

import java.util.PriorityQueue;

public class LC_3264 implements Solution {
    @Override
    public void solve() {

    }

    private int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minH = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            minH.add(new int[]{nums[i], i});
        }
        while (k > 0) {
            int[] n = minH.remove();
            n[0] *= multiplier;
            minH.add(n);
            nums[n[1]] = n[0];
            k--;
        }
        return nums;
    }
}
