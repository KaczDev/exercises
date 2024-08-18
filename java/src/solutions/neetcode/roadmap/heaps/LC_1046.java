package solutions.neetcode.roadmap.heaps;

import solutions.Solution;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC_1046 implements Solution {
    @Override
    public void solve() {
        System.out.println("Solution: "+this.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
    private int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int x = maxHeap.remove();
            int y = maxHeap.remove();
            if (x == y)
                continue;
            if (x > y) {
                x = x - y;
                maxHeap.add(x);
            } else {
                y = y - x;
                maxHeap.add(y);
            }
        }
        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.remove();
    }
}
