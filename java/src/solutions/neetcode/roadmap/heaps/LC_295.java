package solutions.neetcode.roadmap.heaps;

import solutions.Solution;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC_295 implements Solution {
    @Override
    public void solve() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }

    class MedianFinder {
        // small heap always has elements <= to elements in large heap
        // The largest of them will be at the top of the heap
        PriorityQueue<Integer> small;
        // large heap as min heap has the smallest value on the top
        PriorityQueue<Integer> large;

        public MedianFinder() {
            this.small = new PriorityQueue<>(Collections.reverseOrder());
            this.large = new PriorityQueue<>();
        }

        public void addNum(int num) {
            this.small.add(num);
            // make sure every num in small is <= every num in large
            if (!this.small.isEmpty() && !this.large.isEmpty() &&
                    this.small.peek() > this.large.peek()) {
                this.large.add(this.small.remove());
            }
            // uneven size, size diff > 1
            if (small.size() > large.size() + 1) {
                this.large.add(this.small.remove());
            }
            if (large.size() > small.size() + 1) {
                this.small.add(this.large.remove());
            }
        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return (double) small.peek();
            }
            if (large.size() > small.size()) {
                return (double) large.peek();
            }
            return (double) (small.peek() + large.peek()) / 2.0;
        }
    }
}
