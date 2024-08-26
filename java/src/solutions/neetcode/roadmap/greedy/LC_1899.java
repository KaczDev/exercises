package solutions.neetcode.roadmap.greedy;

import solutions.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC_1899 implements Solution {
    @Override
    public void solve() {

        int[][] triplets = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target = {2, 7, 5};
        System.out.println("Solution: " + this.mergeTriplets(triplets, target));
    }

    // Time: O(n)
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> goodIdxs = new HashSet<>();
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    goodIdxs.add(i);
                }
            }
        }
        return goodIdxs.size() == target.length;
    }
}
