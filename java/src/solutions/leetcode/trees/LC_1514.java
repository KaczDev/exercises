package solutions.leetcode.trees;

import solutions.Solution;

import java.util.*;

public class LC_1514 implements Solution {
    @Override
    public void solve() {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;
        System.out.println("Solution: " + this.maxProbability(n, edges, succProb, start, end));
    }

    private double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // adj list
        Map<Integer, Set<Neighbor>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.putIfAbsent(a, new HashSet<>());
            adj.putIfAbsent(b, new HashSet<>());
            adj.get(a).add(new Neighbor(b, succProb[i]));
            adj.get(b).add(new Neighbor(a, succProb[i]));
        }
        if (!adj.containsKey(start_node) || !adj.containsKey(end_node)) {
            return 0.0;
        }
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<Neighbor> minH = new PriorityQueue<>(Comparator.comparing(Neighbor::prob).reversed());
        minH.add(new Neighbor(start_node, 1.0));
        while (!minH.isEmpty()) {
            Neighbor node = minH.remove();
            visit.add(node.n);
            if (node.n == end_node) {
                return node.prob;
            }
            for (Neighbor nei : adj.get(node.n)) {
                if (!visit.contains(nei.n)) {
                    minH.add(new Neighbor(nei.n, nei.prob * node.prob));
                }
            }
        }
        return 0.0;
    }

    record Neighbor(int n, double prob) {
    }
}
