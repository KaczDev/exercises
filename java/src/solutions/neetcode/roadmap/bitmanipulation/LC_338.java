package solutions.neetcode.roadmap.bitmanipulation;

import solutions.Solution;

import java.util.Arrays;

public class LC_338 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+ Arrays.toString(this.countBits(5)));
    }
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        int pow = 2;
        int offset = 1;// highest power of 2
        for (int i = 1; i < n + 1; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}
