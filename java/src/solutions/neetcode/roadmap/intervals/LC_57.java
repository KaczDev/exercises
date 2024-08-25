package solutions.neetcode.roadmap.intervals;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_57 implements Solution {
    @Override
    public void solve() {
        int[][] intervals = new int[][]{{1,3},{6,9}};
        int[] newInterval = new int[]{2,5};
        System.out.println("Solution: "+ Arrays.deepToString(this.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            // First 2 conditions are if the newInterval was not overlapping
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }
                return res.toArray(new int[0][]);
            } else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                //newInterval is overlapping here
                newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]),
                        Math.max(newInterval[1], intervals[i][1])};
            }
        }
        //If we didn't return in the loop
        //it means newInterval overlapped all remaining.
        res.add(newInterval);
        return res.toArray(new int[0][]);
    }
}
