package solutions.neetcode.roadmap.greedy;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_846 implements Solution {
    @Override
    public void solve() {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int gs = 3;
        System.out.println("Solution: " + this.isNStraightHand(hand, gs));
    }

    private boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        // Map of card, countOfCard
        Map<Integer, Integer> counts = new HashMap<>();
        // MinHeap that contains unique minimum card
        // (unique so we don't have 1 and 1 there)
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        for (int h : hand) {
            counts.put(h, counts.getOrDefault(h, 0) + 1);
        }
        minH.addAll(counts.keySet());
        while (!minH.isEmpty()) {
            int first = minH.peek();
            for (int i = first; i < first + groupSize; i++) {
                if (!counts.containsKey(i)) {
                    return false;
                }
                counts.put(i, counts.get(i) - 1);
                if (counts.get(i) == 0) {
                    if (minH.peek() != i) {
                        return false;
                    }
                    minH.remove();
                    counts.remove(i);
                }
            }
        }
        return true;
    }
}
