package solutions.neetcode.roadmap.bitmanipulation;

import solutions.Solution;

public class LC_136 implements Solution {
    @Override
    public void solve() {

        System.out.println("Solution: " + this.singleNumber(new int[]{1, 2, 3, 3, 2}));
        System.out.println("Solution: " + this.singleNumber(new int[]{1,230487, 2, 3, 3, 2,230487}));
    }

    int singleNumber(int[] nums) {
        int res = 0; // 0 ^ n = n;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
