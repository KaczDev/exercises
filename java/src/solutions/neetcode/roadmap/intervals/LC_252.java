package solutions.neetcode.roadmap.intervals;

import solutions.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LC_252 implements Solution {

    @Override
    public void solve() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(0, 30));
        System.out.println("Solution: " + this.canAttendMeetings(intervals));
        intervals = new ArrayList<>();
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(0, 4));
        System.out.println("Solution: " + this.canAttendMeetings(intervals));
    }

    boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) return true;
        intervals.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);
            if (i2.start < i1.end) {
                return false;
            }
        }
        return true;
    }
}
