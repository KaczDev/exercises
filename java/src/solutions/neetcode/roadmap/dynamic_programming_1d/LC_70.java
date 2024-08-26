package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

public class LC_70 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.climbStairs(5));
        System.out.println("Solution: " + this.climbStairs(2));
    }

    public int climbStairs(int n) {
        int one = 1, two = 1;
        for (int i = 0; i < n - 1; i++) {
            int tmp = one;
            one = one + two;
            two = tmp;
        }
        return one;
    }
}
