package solutions.neetcode.roadmap.greedy;

import solutions.Solution;

import java.util.Arrays;

public class LC_134 implements Solution {
    @Override
    public void solve() {
        int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};
        System.out.println("Solution: " + this.canCompleteCircuit(gas, cost));
        gas = new int[]{1, 2, 3, 4, 5};
        cost = new int[]{3, 4, 5, 1, 2};
        System.out.println("Solution: " + this.canCompleteCircuit(gas, cost));
    }

    // Time: O(n)
// Space: O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int total = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }
}
