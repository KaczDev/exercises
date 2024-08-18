package solutions.neetcode.roadmap.heaps;

import solutions.Solution;

import java.util.*;

public class LC_621 implements Solution {
    @Override
    public void solve() {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Solution: " + this.leastInterval(tasks, n));
    }

    record TaskAvailability(int remaining, int allowedEntry) {
    }

    private int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<TaskAvailability> q = new ArrayDeque<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.putIfAbsent(task, 0);
            counts.put(task, counts.get(task) + 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            maxHeap.add(entry.getValue());
        }
        int intervals = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            intervals += 1;
            if (!maxHeap.isEmpty()) {
                int count = maxHeap.remove();
                count -= 1;
                if (count > 0) {
                    q.add(new TaskAvailability(count, intervals + n));
                }
            }
            if (!q.isEmpty() && q.peek().allowedEntry == intervals) {
                maxHeap.add(q.remove().remaining);
            }
        }
        return intervals;
    }
}
