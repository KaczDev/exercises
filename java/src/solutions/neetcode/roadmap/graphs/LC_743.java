package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.*;

public class LC_743 implements Solution {
    @Override
    public void solve() {
        int[][] times = new int[][]{new int[]{2, 1, 1}, new int[]{2, 3, 1}, new int[]{3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println("Solution: " + this.networkDelayTime(times, n, k));
        times = new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
        n = 3;
        k = 1;
        System.out.println("Solution: " + this.networkDelayTime(times, n, k));
    }

    //Time: O(E*log(V)) - Dijkstra's Shortest Path
    private int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<PathN>> edges = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            edges.putIfAbsent(u, new ArrayList<>());
            edges.get(u).add(new PathN(v, w));
        }
        PriorityQueue<PathN> minH = new PriorityQueue<>(Comparator.comparing(PathN::weight));
        minH.add(new PathN(k, 0));
        Set<Integer> visit = new HashSet<>();
        int t = 0;
        while (!minH.isEmpty()) {
            PathN node = minH.remove();
            if (visit.contains(node.node)) {
                continue;
            }
            visit.add(node.node);
            t = Math.max(t, node.weight);
            for (PathN nei : edges.getOrDefault(node.node, new ArrayList<>())) {
                if (!visit.contains(nei.node)) {
                    minH.add(new PathN(nei.node, nei.weight + node.weight));
                }
            }
        }
        if (visit.size() != n) {
            return -1;
        }
        return t;
    }

    record PathN(int node, int weight) {

    }
}
