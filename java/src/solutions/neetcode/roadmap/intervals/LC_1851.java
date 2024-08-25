package solutions.neetcode.roadmap.intervals;

import solutions.Solution;

import java.util.*;

public class LC_1851 implements Solution {
    @Override
    public void solve() {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println("Solution: " + Arrays.toString(this.minInterval(intervals, queries)));
    }

    int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> (a.size == b.size) ? a.r - b.r : a.size - b.size);
        // Query,Result
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        for (int q : sortedQueries) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.add(new Interval(r - l + 1, r));
                i += 1;
            }
            while (!minHeap.isEmpty() && minHeap.peek().r < q) {
                minHeap.remove(); // popping all the invalid intervals from the minHeap
            }
            if (minHeap.isEmpty()) {
                res.put(q, -1);
            } else {
                res.put(q, minHeap.peek().size);
            }
        }
        int[] resArr = new int[queries.length];
        for (int j = 0; j < resArr.length; j++) {
            resArr[j] = res.get(queries[j]);
        }
        return resArr;
    }

    record Interval(int size, int r) {
    }
}
