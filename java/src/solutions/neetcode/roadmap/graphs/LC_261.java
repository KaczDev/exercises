package solutions.neetcode.roadmap.graphs;

import solutions.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_261 implements Solution {
    @Override
    public void solve() {

        int n = 5;
        int[][] edges = new int[][]{new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3}, new int[]{1, 4},
        };
        System.out.println("Solution: " + this.validTree(n, edges));
        int n2 = 5;
        int[][] edges2 = new int[][]{new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3}, new int[]{1, 3}, new int[]{1, 4}
        };
        System.out.println("Solution: " + this.validTree(n2, edges2));
    }

    private boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        //Create an adjacency list
        //Map<Node, ConnectedNodes>
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (int[] conn : edges) {
            int from = conn[0];
            int to = conn[1];
            adjacencyList.putIfAbsent(from, new HashSet<>());
            adjacencyList.putIfAbsent(to, new HashSet<>());
            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);
        }
        //then traverse the graph and check for cycles and if all nodes are visited
        Set<Integer> visited = new HashSet<>();
        return this.dfs(adjacencyList, visited, 0, -1) && visited.size() == n;
    }

    private boolean dfs(Map<Integer, Set<Integer>> adjList, Set<Integer> visited, int n, int prev) {
        if (visited.contains(n)) {
            return false;
        }
        visited.add(n);
        for (int adj : adjList.getOrDefault(n, new HashSet<>())) {
            if (adj == prev) {
                continue;
            }
            if (!this.dfs(adjList, visited, adj, n)) {
                return false;

            }
        }
        return true;
    }

}
