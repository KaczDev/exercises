package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.*;

public class LC_1584 implements Solution {
    @Override
    public void solve() {
        int[][] points = new int[][]{
                new int[]{0, 0}, new int[]{2, 2}, new int[]{3, 10}, new int[]{5, 2}, new int[]{7, 0}
        };
        System.out.println("Solution: " + this.minCostConnectPoints(points));
    }

    // Time: O(n^2*log(n)) //n^2 = edges; log n is from Prim's
    // Prim's algorithm
    private int minCostConnectPoints(int[][] points) {
        int N = points.length;
        // i : list of [code, node]
        //Create adjacency list
        Map<Integer, List<WEdge>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            adj.putIfAbsent(i, new ArrayList<>());
            for (int j = i + 1; j < N; j++) {
                adj.putIfAbsent(j, new ArrayList<>());
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = this.manhattanDistance(x1, y1, x2, y2);
                adj.get(i).add(new WEdge(dist, j));
                adj.get(j).add(new WEdge(dist, i));
            }
        }
        //Prim's algorithm
        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<WEdge> minH = new PriorityQueue<>(Comparator.comparing(WEdge::cost));
        minH.add(new WEdge(0, 0));
        while (visit.size() < N) {
            WEdge costPoint = minH.remove();
            if (visit.contains(costPoint.node)) {
                continue;
            }
            res += costPoint.cost;
            visit.add(costPoint.node);
            for (WEdge nei : adj.get(costPoint.node)) {
                if (!visit.contains(nei.node)) {
                    minH.add(nei);
                }
            }
        }
        return res;
    }

    record WEdge(int cost, int node) {
    }

    private int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
