package solutions.neetcode.roadmap.intervals;

import solutions.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class LC_435 implements Solution {
    @Override
    public void solve() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Solution: " + this.eraseOverlapIntervals(intervals));
    }

    //Time: O(n log(n))
    private int eraseOverlapIntervals(int[][] intervals) {
        //sort by the starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int res = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                res += 1;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            }
        }
        return res;
    }
}
