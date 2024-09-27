package solutions.leetcode.intervals;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC_731 implements Solution {
    @Override
    public void solve() {
        MyCalendarTwo mc2  = new MyCalendarTwo();
        System.out.println(mc2.book(10,20));
        System.out.println(mc2.book(50,60));
    System.out.println(mc2.book(10,40));
    System.out.println(mc2.book(5,15));
    System.out.println(mc2.book(5,10));
    System.out.println(mc2.book(25,55));
    }
    class MyCalendarTwo {
        record Event(int start, int end) {
        }

        List<Event> nonOverlapping;
        List<Event> overlapping;

         MyCalendarTwo() {
            this.nonOverlapping = new ArrayList<>();
            this.overlapping = new ArrayList<>();
        }

         boolean book(int start, int end) {
            for (Event e : this.overlapping) {
                if (end > e.start && e.end > start) {
                    return false;
                }
            }
            for (Event e : this.nonOverlapping) {
                if (end > e.start && e.end > start) {
                    Event newE = new Event(Math.max(e.start, start), Math.min(e.end, end));
                    this.overlapping.add(newE);
                }
            }
            this.nonOverlapping.add(new Event(start, end));
            return true;
        }
    }
}
