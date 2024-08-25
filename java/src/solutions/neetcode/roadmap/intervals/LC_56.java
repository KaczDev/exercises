package solutions.neetcode.roadmap.intervals;

import solutions.Solution;

import java.util.*;

public class LC_56 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: " + Arrays.deepToString(this.merge(new int[][]{{1, 3}, {2,6},{8,10},{15,18}})));
        System.out.println("Solution: " + Arrays.deepToString(this.merge(new int[][]{{1, 4}, {1, 4}})));
    }
    private int[][] merge(int[][] intervals) {
        // sort by the start value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int i1End = merged.get(merged.size() - 1)[1];
            int i2Start = intervals[i][0];
            int i2End = intervals[i][1];
            if (i2Start <= i1End) {
                merged.get(merged.size() - 1)[1] = Math.max(i1End, i2End);
            } else {
                merged.add(intervals[i]);
            }
        }
        return merged.toArray(new int[0][]);
    }
}
