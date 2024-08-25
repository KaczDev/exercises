package solutions.neetcode.roadmap.intervals;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_253 implements Solution {
    @Override
    public void solve() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 40));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        System.out.println("Solution: " + this.minMeetingRooms(intervals));
        intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(0, 30));
        System.out.println("Solution: " + this.minMeetingRooms(intervals));
        intervals = new ArrayList<>();
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(0, 4));
        System.out.println("Solution: " + this.minMeetingRooms(intervals));
    }

    //Time: O(n*log(n))
    //Space: O(n^2)
    int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals.size();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0, count = 0;
        int s = 0, e = 0;
        while (s < intervals.size()) {
            if (start[s] < end[e]) {
                s += 1;
                count += 1;
            } else {
                e += 1;
                count -= 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
