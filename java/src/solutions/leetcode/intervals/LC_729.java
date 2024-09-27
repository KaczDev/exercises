package solutions.leetcode.intervals;

import solutions.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC_729 implements Solution {
    @Override
    public void solve() {
        MyCalendarList mcl = new MyCalendarList();
        System.out.println(mcl.book(10,20));
        System.out.println(mcl.book(15,25));
        System.out.println(mcl.book(20,30));

        MyCalendarBST mcbst = new MyCalendarBST();
        System.out.println(mcbst.book(10,20));
        System.out.println(mcbst.book(15,25));
        System.out.println(mcbst.book(20,30));
    }

    //Binary tree solution
    //Time: O(log N)
    class Tree {
        Tree left;
        Tree right;
        int start;
        int end;

        Tree(int start, int end) {
            this.left = null;
            this.right = null;
            this.start = start;
            this.end = end;
        }

        boolean insert(int start, int end) {
            Tree curr = this;
            while (true) {
                if (start >= curr.end) {
                    if (curr.right == null) {
                        curr.right = new Tree(start, end);
                        return true;
                    }
                    curr = curr.right;
                } else if (end <= curr.start) {
                    if (curr.left == null) {
                        curr.left = new Tree(start, end);
                        return true;
                    }
                    curr = curr.left;
                } else {
                    return false;
                }
            }
        }
    }

    class MyCalendarBST {
        Tree root;

        MyCalendarBST() {
            this.root = null;
        }

        boolean book(int start, int end) {
            if (this.root == null) {
                this.root = new Tree(start, end);
                return true;
            }
            return this.root.insert(start, end);
        }
    }

    //List solution
//Time:O(n^2)
    class MyCalendarList {
        record Event(int start, int end) {
        }

        List<Event> events;

        MyCalendarList() {
            this.events = new ArrayList<>();
        }

        boolean book(int start, int end) {
            for (Event e : this.events) {
                if (e.end > start && end > e.start) {
                    return false;
                }
            }
            this.events.add(new Event(start, end));
            return true;
        }
    }
}
