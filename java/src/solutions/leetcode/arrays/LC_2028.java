package solutions.leetcode.arrays;

import solutions.Solution;

import java.util.Arrays;

public class LC_2028 implements Solution {
    @Override
    public void solve() {
        int[] rolls = {3, 2, 4, 3};
        int mean = 4;
        int n = 2;
        System.out.println("Solution: " + Arrays.toString(this.missingRolls(rolls, mean, n)));
    }

    //Time: O(n)
    private int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = (rolls.length + n) * mean;
        int rollsSum = Arrays.stream(rolls).sum();
        int missingSum = sum - rollsSum;

        if (missingSum > 6 * n || missingSum < n) {
            return new int[0];
        }
        int[] res = new int[n];
        int i = 0;
        while (n > 0) {
            int dice = Math.min(6, missingSum - n + 1);
            res[i] = dice;
            missingSum -= dice;
            n -= 1;
            i += 1;
        }
        return res;
    }
}
