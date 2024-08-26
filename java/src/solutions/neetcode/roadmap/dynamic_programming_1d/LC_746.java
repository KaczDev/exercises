package solutions.neetcode.roadmap.dynamic_programming_1d;

import solutions.Solution;

import java.util.Arrays;

public class LC_746 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + this.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    private int minCostClimbingStairs(int[] cost) {
//        Solution with adding the 0 to the end of an []
//        cost = Arrays.copyOf(cost, cost.length + 1);
//        cost[cost.length - 1] = 0;
//        for (int i = cost.length - 3; i >= 0; i--) {
//            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
//        }
//        return Math.min(cost[0], cost[1]);

//         Solution without adding 0 to the end of cost[]
//        for (int i = cost.length - 3; i >= 0; i--) {
//            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
//        }
//        return Math.min(cost[0], cost[1]);
        //Solution without modifying the input
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }
}
