package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

public class LC_152 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println("Solution: " + this.maxProduct(new int[]{-2, 0, -1}));
    }

    //Time: O(n)
    private int maxProduct(int[] nums) {
        int res = nums[0];
        int max = 1;
        int min = 1;

        for (int n : nums) {
            int tmp = max * n;
            max = Math.max(Math.max(max * n, min * n), n);
            min = Math.min(Math.min(tmp, min * n), n);
            res = Math.max(max, res);
        }
        return res;
    }
}
